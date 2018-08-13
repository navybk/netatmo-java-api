package io.rudolph.netatmo.api.welcome

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.presence.PresenceConnector
import io.rudolph.netatmo.api.presence.model.Events
import io.rudolph.netatmo.api.presence.model.PersonsEvent
import io.rudolph.netatmo.api.welcome.service.WelcomeService
import io.rudolph.netatmo.executable
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.executable.PlainExecutable
import retrofit2.Retrofit

class WelcomeConnector(api: Retrofit) : PresenceConnector(api) {
    private val welcomeService = api.create(WelcomeService::class.java)

    /**
     * Returns most recent events.
     *
     * required scope: read_camera, access_camera
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/getlasteventof)
     * @param homeId ID of the Home you're interested in
     * @param personId Your request will retrieve all events of the given home until the most recent event of the given person
     * @param offset Number of events to retrieve. Default is 30.
     * @return an executable object to obtain the List of [io.rudolph.netatmo.api.presence.model.Event]
     */
    fun getLastEventOf(homeId: String,
                       personId: String,
                       offset: Int? = null): BodyResultExecutable<Events> {
        return welcomeService.getLastEventOf(
                accessToken = "",
                homeId = homeId,
                personId = personId,
                offset = offset
        ).executable
    }

    /**
     * Sets a person as "Away" or the Home as "Empty". The event will be added to the user’s timeline.
     *
     * required scope: write_camera
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/setpersonsaway)
     *
     * @param homeId ID of the Home you're interested in
     * @param personId If a person_id is specified, that person will be set as "Away". If no person_id is specified, the Home will be set as "Empty".
     * @return an executable object to obtain the [BaseResult]
     */
    fun setPersonsAway(homeId: String, personId: String? = null): PlainExecutable<BaseResult> {
        return welcomeService.setPersonsAway(
                accessToken = "",
                homeId = homeId,
                personId = personId
        ).executable
    }

    /**
     * Sets a person as "Home"". The event will be added to the user’s timeline.
     *
     * required scope: write_camera
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/setpersonshome)
     *
     * @param homeId ID of the Home you're interested in
     * @param personIds Array of person_id
     * @return an executable object to obtain the [BaseResult]
     */
    fun setPersonsHome(homeId: String, personIds: List<String>): PlainExecutable<BaseResult> {
        return welcomeService.setPersonsHome(
                accessToken = "",
                homeId = homeId,
                personIds = personIds
        ).executable
    }

    /**
     * Sets a person as "Home"". The event will be added to the user’s timeline.
     *
     * required scope: write_camera
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/setpersonshome)
     *
     * @param homeId ID of the Home you're interested in
     * @param personId id of person the home status to be set
     * @return an executable object to obtain the [BaseResult]
     */
    fun setPersonsHome(homeId: String, personId: String): PlainExecutable<BaseResult> {
        return setPersonsHome(homeId, listOf(personId))
    }

    fun onExternalCameraEvent(jsonString: String): PersonsEvent? {
        return try {
            JacksonTransform.deserialize<PersonsEvent>(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}