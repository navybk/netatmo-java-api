package io.rudolph.netatmo.executable

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.model.BackendError
import io.rudolph.netatmo.oauth2.model.ErrorResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call

class AsyncCallExecutable<T, E>(private val call: Call<T>,
                                private val errorFunction: ((BackendError) -> Unit)? = null,
                                private val transForm: ((T) -> E?)? = null) : AsyncExecutable<E> {


    @Suppress("UNCHECKED_CAST")
    override fun executeAsync(resultFunction: (E) -> Unit) {
        GlobalScope.launch {
            call.execute().apply {
                if (isSuccessful) {

                    val body: T = body() ?: run {
                        errorFunction?.invoke(
                                JacksonTransform.deserialize<ErrorResult>(errorBody().toString())
                                        ?.error
                                        ?: BackendError(0, "${code()}: Empty body not expected")
                        )
                        return@launch
                    }
                    val result: E? = transForm?.invoke(body) ?: body as? E

                    runBlocking {
                        result?.apply {
                            resultFunction(this)
                        } ?: errorFunction?.invoke(
                                BackendError(0, "${code()}: Empty body not expected"))
                    }
                    return@launch
                }

                runBlocking {
                    errorFunction?.invoke(
                            BackendError(0, "${code()}: ${message()}"))
                }
            }
        }
    }
}