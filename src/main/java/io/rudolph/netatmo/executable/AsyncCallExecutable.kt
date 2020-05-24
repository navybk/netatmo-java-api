package io.rudolph.netatmo.executable

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.model.BackendError
import io.rudolph.netatmo.oauth2.model.ErrorResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class AsyncCallExecutable<T, E>(private val call: suspend () -> T,
                                private val errorFunction: ((BackendError) -> Unit)? = null,
                                private val transForm: ((T) -> E?)? = null) : AsyncExecutable<E> {


    @Suppress("UNCHECKED_CAST")
    override fun executeAsync(resultFunction: (E) -> Unit) {
        GlobalScope.launch {
            try {
                call()?.apply {
                    val result: E? = transForm?.invoke(this) ?: this as? E

                    withContext(Dispatchers.Unconfined) {
                        result?.apply {
                            resultFunction(this)
                        } ?: errorFunction?.invoke(
                                BackendError(0, "Transform failed"))
                    }
                }
            } catch (httpException: HttpException) {
                errorFunction?.invoke(
                        JacksonTransform.deserialize<ErrorResult>(httpException.message())
                                ?.error
                                ?: BackendError(0, "${httpException.code()}: Empty body not expected"))
            } catch (exception: Exception) {
                errorFunction?.invoke(
                        BackendError(0, "unexpected result"))
            }
        }
    }
}