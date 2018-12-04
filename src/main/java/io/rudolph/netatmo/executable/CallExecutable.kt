package io.rudolph.netatmo.executable

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.model.BackendError
import io.rudolph.netatmo.oauth2.model.ErrorResult
import retrofit2.Call


@Suppress("UNCHECKED_CAST")
abstract class CallExecutable<T, E>(internal val call: Call<T>, private val transForm: (T) -> E? = { it as? E }) : Executable<E> {

    private var errorFunction: ((BackendError) -> Unit)? = null

    override fun onError(errorFunction: (BackendError) -> Unit): Executable<E> {
        this.errorFunction = errorFunction
        return this
    }

    override fun executeAsync(callback: Executable.Callback<E>) {
        AsyncCallExecutable(call = call,
                errorFunction = { error: BackendError -> callback.onError(error) },
                transForm = transForm)
                .executeAsync { result -> callback.onResult(result) }
    }

    override fun executeAsync(resultFunction: (E) -> Unit) {
        AsyncCallExecutable(call = call,
                errorFunction = errorFunction,
                transForm = transForm)
                .executeAsync(resultFunction)
    }


    override fun executeSync(): E? {
        return call.execute().let {
            it.errorBody()?.apply {
                val error = JacksonTransform.deserialize<ErrorResult>(this.string())
                errorFunction?.invoke(error?.error ?: BackendError(0, "unknown"))
            }
            it.body()
                    ?.let { body ->
                        transForm(body)
                    }
        }
    }
}
