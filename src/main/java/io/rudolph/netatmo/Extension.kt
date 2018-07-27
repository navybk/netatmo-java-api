package io.rudolph.netatmo

import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.executable.PlainExecutable
import retrofit2.Call

val <T> Call<T>.executable: PlainExecutable<T>
    get() = PlainExecutable(this)

val <T> Call<TypedBaseResult<T>>.executable: BodyResultExecutable<T>
    get() = BodyResultExecutable(this)