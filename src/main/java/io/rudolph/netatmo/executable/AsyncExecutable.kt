package io.rudolph.netatmo.executable

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Call

class AsyncExecutable<T, E>(private val call: Call<T>, private val errorFunction: ((String) -> Unit)? = null, private val transForm: ((T) -> E)? = null) {

    /**
     * execute a call asynchronously with the power of kotlin coroutines
     *
     * @param resultFunction the function called in case of success with the parsed body as object
     */
    fun executeAsync(resultFunction: (E) -> Unit) {
        launch {
            call.execute().apply {
                if (isSuccessful) {

                    val body: T = body() ?: let {
                        errorFunction?.invoke(
                                "${code()}: Empty body not expected")
                        return@launch
                    }
                    val result: E? = transForm?.invoke(body) ?: body as? E

                    runBlocking {
                        result?.apply {
                            resultFunction(this)
                        } ?: errorFunction?.invoke(
                                "${code()}: Empty body not expected")
                    }
                    return@launch
                }

                runBlocking {
                    errorFunction?.invoke(
                            "${code()}: ${message()}")
                }
            }
        }
    }
}