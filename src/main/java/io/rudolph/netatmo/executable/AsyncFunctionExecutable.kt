package io.rudolph.netatmo.executable

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class AsyncFunctionExecutable<T, E>(private val function: () -> T,
                                    private val errorFunction: ((String) -> Unit)? = null,
                                    private val transForm: ((T) -> E)? = null) : AsyncExecutable<E> {


    @Suppress("UNCHECKED_CAST")
    override fun executeAsync(resultFunction: (E) -> Unit) {
        launch {
            val functionResult = function()
            val result: E? = transForm?.invoke(functionResult) ?: functionResult as? E

            runBlocking {
                result?.apply {
                    resultFunction(this)
                } ?: errorFunction?.invoke(
                        "Empty object not expected")
            }
        }
    }
}
