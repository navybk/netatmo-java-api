package io.rudolph.netatmo.executable

import retrofit2.Call

class PlainCallExecutable<T>(call: Call<T>) : CallExecutable<T, T>(call)