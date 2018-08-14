package io.rudolph.netatmo.executable


@Suppress("UNCHECKED_CAST")
abstract class FunctionExecutable<T, E>(internal val function: () -> T, private val transForm: (T) -> E = { (it as? E)!! }) : Executable<E> {

    override fun onError(errorFunction: (String) -> Unit): AsyncFunctionExecutable<T, E> {
        return AsyncFunctionExecutable(function, errorFunction, transForm)
    }

    override fun executeAsync(callback: Executable.Callback<E>) {
        AsyncFunctionExecutable(function = function,
                errorFunction = { error: String -> callback.onError(error) },
                transForm = transForm)
                .executeAsync { result -> callback.onResult(result) }
    }

    override fun executeSync(): E? {
        return function()?.let { transForm(it) }
    }
}
