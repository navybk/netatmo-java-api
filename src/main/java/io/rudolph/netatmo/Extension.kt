package io.rudolph.netatmo

import io.rudolph.netatmo.executable.Executable
import retrofit2.Call

val <T> Call<T>.executable: Executable<T>
    get() = Executable(this)