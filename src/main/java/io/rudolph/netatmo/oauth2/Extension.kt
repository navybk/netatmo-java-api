package io.rudolph.netatmo.oauth2

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.model.BackendError
import io.rudolph.netatmo.oauth2.model.ErrorResult
import mu.KotlinLogging
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.time.LocalDateTime
import java.time.ZoneId

internal val logger = KotlinLogging.logger("Netamo Api")

fun Interceptor.Chain.errorbuilder(code: Int = 0, error: BackendError): Response {
    val message = "${error.message}"
    return Response.Builder().request(this.request())
            .protocol(Protocol.HTTP_1_1)
            .code(code)
            .body(message.toResponseBody("text/plain".toMediaTypeOrNull()))
            .message(message)
            .build()
}

fun Interceptor.Chain.proceed(accessToken: String): Response {
    val url = request().url.queryParameter("access_token")?.let {
        request().url
                .newBuilder()
                .removeAllEncodedQueryParameters("access_token")
                .addEncodedQueryParameter("access_token", accessToken)
                .build()
    } ?: request().url

    return proceed(this.request()
            .newBuilder()
            .url(url)
            .removeHeader("Authorization")
            .addHeader("Authorization", "Bearer $accessToken")
            .build())
}

fun Response.createErrorBody(): BackendError {
    return body?.string()?.let {
        JacksonTransform.parse<ErrorResult>(it)?.error ?: BackendError(0, it)
    } ?: BackendError(0, "empty body")
}

fun LocalDateTime?.toTimestamp() = this?.let {
    toTimestamp()
}

fun LocalDateTime.toTimestamp(): Long {
    val zoneId = ZoneId.systemDefault()
    return atZone(zoneId).toEpochSecond()
}