package io.rudolph.netatmo.executable

interface AsyncExecutable<T> {

    /**
     * execute a call asynchronously with the power of kotlin coroutines
     *
     * @param resultFunction the function called in case of success with the parsed body as object
     */
    @Suppress("UNCHECKED_CAST")
    fun executeAsync(resultFunction: (T) -> Unit)
}