package io.rudolph.netatmo.executable

import retrofit2.Call

class PlainExecutable<T>(call: Call<T>): Executable<T, T>(call)