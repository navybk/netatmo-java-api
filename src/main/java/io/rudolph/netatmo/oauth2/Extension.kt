package io.rudolph.netatmo.oauth2

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.model.ErrorResult
import mu.KotlinLogging
import okhttp3.*
import java.time.LocalDateTime
import java.time.ZoneId

internal val logger = KotlinLogging.logger("Netamo Api")

fun Interceptor.Chain.errorbuilder(code: Int = 0, error: ErrorResult.Error): Response {
    val message = "${error.message}"
    return Response.Builder().request(this.request())
            .protocol(Protocol.HTTP_1_1)
            .code(code)
            .body(ResponseBody.create(MediaType.parse("text/plain"), message))
            .message(message)
            .build()
}

fun Interceptor.Chain.proceed(accessToken: String): Response {
    val url = request().url().queryParameter("access_token")?.let {
        request().url()
                .newBuilder()
                .removeAllEncodedQueryParameters("access_token")
                .addEncodedQueryParameter("access_token", accessToken)
                .build()
    } ?: request().url()

    return this.request()
            .newBuilder()
            .url(url)
            .removeHeader("Authorization")
            .addHeader("Authorization", "Bearer $accessToken")

            .build().let {
                proceed(it)
            }.let {
                if (it.isSuccessful) {
                    it
                } else {
                    val error = it.createErrorBody()
                    errorbuilder(it.code(), error)
                }
            }
}

fun Response.createErrorBody(): ErrorResult.Error {
    return body()?.string()?.let {
        JacksonTransform.parse<ErrorResult>(it)?.error ?: ErrorResult.Error(0, it)
    } ?: ErrorResult.Error(0, "empty body")
}

fun LocalDateTime?.toTimestamp() = this?.let {
    toTimestamp()
}

fun LocalDateTime.toTimestamp(): Long {
    val zoneId = ZoneId.systemDefault()
    return atZone(zoneId).toEpochSecond()
}