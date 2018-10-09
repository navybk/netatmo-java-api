package io.rudolph.netatmo.executable

import retrofit2.Call


@Suppress("UNCHECKED_CAST")
abstract class CallExecutable<T, E>(internal val call: Call<T>, private val transForm: (T) -> E? = { it as? E }) : Executable<E> {

    override fun onError(errorFunction: (String) -> Unit): AsyncCallExecutable<T, E> {
        return AsyncCallExecutable(call, errorFunction, transForm)
    }

    override fun executeAsync(callback: Executable.Callback<E>) {
        AsyncCallExecutable(call = call,
                errorFunction = { error: String -> callback.onError(error) },
                transForm = transForm)
                .executeAsync { result -> callback.onResult(result) }
    }


    override fun executeSync(): E? {
        return call.execute().body()?.let {
            transForm(it)
        }
    }
}
