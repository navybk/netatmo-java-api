package apitest

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.transform.JacksonTransform


data class TestConfig(
        @JsonProperty("clientId")
        val clientId: String? = null,

        @JsonProperty("clientSecret")
        val clientSecret: String? = null,

        @JsonProperty("userMail")
        val userMail: String? = null,

        @JsonProperty("userPassword")
        val userPassword: String? = null,

        @JsonProperty("accessToken")
        val accessToken: String? = null,

        @JsonProperty("refreshToken")
        val refreshToken: String? = null) {

    companion object {
        fun buildFromFile(path: String): TestConfig? {
            val stream = TestConfig::class.java.getResourceAsStream(path).bufferedReader()
            return JacksonTransform.mapper.readValue(stream, TestConfig::class.java)
        }
    }
}
