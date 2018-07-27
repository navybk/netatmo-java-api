package io.rudolph.netatmo.oauth2.networkinterceptor

import io.rudolph.netatmo.oauth2.errorbuilder
import io.rudolph.netatmo.oauth2.model.ErrorResult
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeoutException

internal class TimeoutInterceptor(private val debug: Boolean = false) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (exception: TimeoutException) {
            if (debug) {
                exception.printStackTrace()
            }
            chain.errorbuilder(error = ErrorResult.Error(0, "Timeout on request"))
        } catch (e: Exception) {
            if (debug) {
                e.printStackTrace()
            }
            chain.errorbuilder(error = ErrorResult.Error(0, "Fatal error: ${e.localizedMessage}"))
        }
    }
}