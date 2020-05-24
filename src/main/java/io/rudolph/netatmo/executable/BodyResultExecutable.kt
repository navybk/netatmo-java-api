package io.rudolph.netatmo.executable

import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import kotlinx.coroutines.runBlocking

class BodyResultExecutable<T>(call: suspend () -> TypedBaseResult<T>) : SafeCallExecutable<TypedBaseResult<T>, T>(call, { it.body }) {

    /**
     * execute the call synchronously
     *
     * @return the parsed call's body as given type object
     */
    fun executeSyncWrapped(): TypedBaseResult<T>? {
        return runBlocking {
            call()
        }
    }

}