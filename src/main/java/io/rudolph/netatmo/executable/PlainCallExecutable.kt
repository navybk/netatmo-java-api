package io.rudolph.netatmo.executable

class PlainCallExecutable<T>(call: suspend () -> T) : SafeCallExecutable<T, T>(call)