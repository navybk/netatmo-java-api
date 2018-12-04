package io.rudolph.netatmo.executable

import io.rudolph.netatmo.oauth2.model.BackendError


@Suppress("UNCHECKED_CAST")
abstract class FunctionExecutable<T, E>(internal val function: () -> T, private val transForm: (T) -> E = { (it as? E)!! }) : Executable<E> {

    private var errorFunction: ((BackendError) -> Unit)? = null

    override fun onError(errorFunction: (BackendError) -> Unit): Executable<E> {
        this.errorFunction = errorFunction
        return this
    }

    override fun executeAsync(callback: Executable.Callback<E>) {
        AsyncFunctionExecutable(function = function,
                errorFunction = { error: BackendError ->
                    callback.onError(error)
                    errorFunction?.invoke(error)
                },
                transForm = transForm)
                .executeAsync { result -> callback.onResult(result) }
    }

    override fun executeAsync(resultFunction: (E) -> Unit) {
        AsyncFunctionExecutable(function = function,
                errorFunction = errorFunction,
                transForm = transForm)
                .executeAsync(resultFunction)
    }

    override fun executeSync(): E? {
        return function()?.let { transForm(it) }
                ?: null.apply {
                    errorFunction?.invoke(
                            BackendError(0, "function returned null")
                    )
                }
    }
}
