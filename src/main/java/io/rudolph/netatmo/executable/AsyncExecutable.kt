package io.rudolph.netatmo.executable

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Call

class AsyncExecutable<T>(private val call: Call<T>, private val errorFunction: ((String) -> Unit)? = null) {

    /**
     * execute a call asynchronously with the power of kotlin coroutines
     *
     * @param resultFunction the function called in case of success with the parsed body as object
     */
    fun executeAsync(resultFunction: (T) -> Unit) {
        launch {
            call.execute().apply {
                if (isSuccessful) {
                    runBlocking {
                        body()?.apply(resultFunction) ?: errorFunction?.invoke(
                                "${code()}: Empty body not expected")
                    }
                    return@launch
                }

                runBlocking {
                    errorFunction?.invoke(
                            "${code()}: ${errorBody()?.string()}")
                }
            }
        }
    }
}