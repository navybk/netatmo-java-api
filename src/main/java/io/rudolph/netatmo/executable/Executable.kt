package io.rudolph.netatmo.executable

import retrofit2.Call

class Executable<T>(private val call: Call<T>) {

    /**
     * Added for Java compatibility
     */
    interface Callback<T> {
        /**
         * will be called if a call was successful and returns a body with given type
         *
         * @param value parsed return body of given type
         */
        fun onResult(value: T)

        /**
         * will be called if a call failed for any reason
         *
         * @param error a readable error reason
         */
        fun onError(error: String)
    }

    /**
     * introduces the async object with the given errorfunction
     *
     * @param errorFunction a lambda with a error representing String as parameter
     * @return an [AsyncExecutable] which provides the async execution of the given call
     */
    fun onError(errorFunction: (String) -> Unit): AsyncExecutable<T> {
        return AsyncExecutable(call, errorFunction)
    }


    /**
     * execute the call asynchronously with a callback object for return values
     *
     * @param callback the [Callback] object which includes the success and error methods
     */
    fun executeAsync(callback: Callback<T>) {
        AsyncExecutable(call) { error -> callback.onError(error)}
                .executeAsync { result -> callback.onResult(result) }
    }

    /**
     * execute the call synchronously
     *
     * @return the parsed call's body as given type object
     */
    fun executeSync(): T? {
        return call.execute().body()
    }
}