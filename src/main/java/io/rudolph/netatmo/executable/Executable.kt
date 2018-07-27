package io.rudolph.netatmo.executable

import retrofit2.Call


abstract class Executable<T, E>(internal val call: Call<T>, private val transForm: (T) -> E = { (it as? E)!! }) {

    /**
     * Added for Java compatibility
     */
    interface Callback<E> {
        /**
         * will be called if a call was successful and returns a body with given type
         *
         * @param value parsed return body of given type
         */
        fun onResult(value: E)

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
    fun onError(errorFunction: (String) -> Unit): AsyncExecutable<T, T> {
        return AsyncExecutable(call, errorFunction)
    }

    /**
     * execute the call asynchronously with a callback object for return values
     *
     * @param callback the [Callback] object which includes the success and error methods
     */
    open fun executeAsync(callback: Callback<E>) {
        AsyncExecutable(call = call,
                errorFunction = { error: String -> callback.onError(error) },
                transForm = transForm)
                .executeAsync { result -> callback.onResult(result) }
    }

    /**
     * execute the call synchronously
     *
     * @return the parsed call's body as given type object
     */
    open fun executeSync(): E? {
        return call.execute().body()?.let {
            transForm(it)
        }
    }
}
