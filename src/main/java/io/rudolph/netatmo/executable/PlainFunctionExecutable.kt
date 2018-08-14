package io.rudolph.netatmo.executable

class PlainFunctionExecutable<T>(function: () -> T) : FunctionExecutable<T, T>(function)