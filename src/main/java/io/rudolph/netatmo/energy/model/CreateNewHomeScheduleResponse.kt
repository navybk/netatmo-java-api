package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


open class CreateNewHomeScheduleResponse(

        @JsonProperty("schedule_id")
        val scheduleId: String? = null
)

