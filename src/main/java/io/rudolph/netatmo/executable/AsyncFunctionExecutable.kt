package io.rudolph.netatmo.executable

import io.rudolph.netatmo.oauth2.model.BackendError
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AsyncFunctionExecutable<T, E>(private val function: () -> T,
                                    private val errorFunction: ((BackendError) -> Unit)? = null,
                                    private val transForm: ((T) -> E)? = null) : AsyncExecutable<E> {


    @Suppress("UNCHECKED_CAST")
    override fun executeAsync(resultFunction: (E) -> Unit) {
        GlobalScope.launch {
            val functionResult = function() ?: run {
                runBlocking {
                    errorFunction?.invoke(BackendError(0, "Empty object not expected"))
                }
                return@launch
            }

            val result: E? = transForm?.invoke(functionResult)

            runBlocking {
                result?.apply {
                    resultFunction(this)
                } ?: errorFunction?.invoke(
                        BackendError(0, "Empty object not expected")
                )
            }
        }
    }

}
