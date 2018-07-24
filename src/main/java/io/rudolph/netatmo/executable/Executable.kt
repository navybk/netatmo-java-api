package io.rudolph.netatmo.executable

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Call

class Executable<T> (private val call: Call<T>) {

    private var errorFunction: ((String) -> Unit)? = null

    interface Callback<T>{
        fun onResult(value: T?)
        fun onError(error: String)
    }

    fun onError(errorFunction: (String) -> Unit): Executable<T> {
        this.errorFunction = errorFunction
        return this
    }

    fun executeAsync(resultFunction:(T?) -> Unit) {
        launch {
                call.execute().apply {
                if (isSuccessful) {
                    runBlocking {
                        body().apply(resultFunction)
                    }
                    return@launch
                }

                runBlocking {
                    errorFunction?.invoke(
                            "${code()}: ${errorBody().toString()}")
                    errorFunction = null
                }

            }
        }
    }

    fun executeAsync(callback: Callback<T?>) {
        errorFunction = {error -> callback.onError(error)}
        executeAsync{result -> callback.onResult(result)}
    }

    fun executeSync() : T? {
        return call.execute().body()
    }
}