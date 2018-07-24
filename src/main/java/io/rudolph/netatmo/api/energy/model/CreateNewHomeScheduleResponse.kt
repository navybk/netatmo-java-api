package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


open class CreateNewHomeScheduleResponse(

        @JsonProperty("schedule_id")
        val scheduleId: String? = null
)

