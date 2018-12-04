package io.rudolph.netatmo.executable

import io.rudolph.netatmo.oauth2.model.BackendError


@Suppress("UNCHECKED_CAST")
interface Executable<T> {

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
        fun onError(error: BackendError)
    }

    /**
     * introduces the async object with the given errorfunction
     *
     * @param errorFunction a lambda with a error representing String as parameter
     * @return an [AsyncCallExecutable] which provides the async execution of the given call
     */
    fun onError(errorFunction: (BackendError) -> Unit): Executable<T>

    /**
     * execute the call synchronously
     *
     * @return the parsed call's body as given type object
     */
    fun executeSync(): T?

    /**
     * execute the call asynchronously with a callback object for return values
     *
     * @param callback the [Callback] object which includes the success and error methods
     */
    fun executeAsync(callback: Executable.Callback<T>)

    /**
     * execute the call asynchronously with a callback object for return values
     *
     * @param resultFunction the function which includes the success object
     */
    fun executeAsync(resultFunction: (T) -> Unit)

}
