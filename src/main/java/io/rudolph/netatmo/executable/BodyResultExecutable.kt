package io.rudolph.netatmo.executable

import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import retrofit2.Call

class BodyResultExecutable<T>(call: Call<TypedBaseResult<T>>) : Executable<TypedBaseResult<T>, T>(call, { it.body!! }) {

    /**
     * execute the call synchronously
     *
     * @return the parsed call's body as given type object
     */
    fun executeSyncWrapped(): TypedBaseResult<T>? {
        return call.execute().body()
    }

}