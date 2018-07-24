package io.rudolph.netatmo.oauth2

import mu.KotlinLogging
import okhttp3.*
import java.time.LocalDateTime
import java.time.ZoneId

internal val logger = KotlinLogging.logger {}

fun Interceptor.Chain.errorbuilder(errorMessage: String): Response {
    return Response.Builder().request(this.request())
            .protocol(Protocol.HTTP_1_1)
            .code(400)
            .body(ResponseBody.create(MediaType.parse("text/plain"), errorMessage))
            .message(errorMessage)
            .build()
}

fun Interceptor.Chain.proceed(accessToken: String): Response {
    return this.request()
            .newBuilder()
            .removeHeader("Authorization")
            .addHeader("Authorization", "Bearer $accessToken")
            .build().let {
                proceed(it)
            }
}

fun LocalDateTime?.toTimestamp() = this?.let {
    toTimestamp()
}

fun LocalDateTime.toTimestamp(): Long {
    val zoneId = ZoneId.systemDefault()
    return atZone(zoneId).toEpochSecond()
}