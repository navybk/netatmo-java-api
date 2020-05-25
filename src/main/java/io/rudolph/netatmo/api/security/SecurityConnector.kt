package io.rudolph.netatmo.api.security

import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.security.model.*
import io.rudolph.netatmo.api.security.service.SecurityService
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.executable.Executable
import io.rudolph.netatmo.executable.PlainCallExecutable
import io.rudolph.netatmo.oauth2.model.BackendError
import retrofit2.Retrofit

class SecurityConnector(api: Retrofit) : CommonConnector(api) {
    private val securityService = api.create(SecurityService::class.java)

    /**
     * Returns most recent events.
     *
     * required scope: read_camera, access_camera
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/getlasteventof)
     * @param homeId ID of the Home you're interested in
     * @param personId Your request will retrieve all events of the given home until the most recent event of the given person
     * @param offset Number of events to retrieve. Default is 30.
     * @return an executable object to obtain the List of [io.rudolph.netatmo.api.security.model.Event]
     */
    @JvmOverloads
    fun getLastEventOf(homeId: String,
                       personId: String,
                       offset: Int? = null): BodyResultExecutable<Events> {
        return BodyResultExecutable {
            securityService.getLastEventOf(
                    homeId = homeId,
                    personId = personId,
                    offset = offset)
        }
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
    @JvmOverloads
    fun setPersonsAway(homeId: String, personId: String? = null): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            securityService.setPersonsAway(
                    homeId = homeId,
                    personId = personId
            )
        }
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
    @JvmOverloads
    fun setPersonsHome(homeId: String, personIds: List<String>): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            securityService.setPersonsHome(
                    homeId = homeId,
                    personIds = personIds)
        }
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
    fun setPersonsHome(homeId: String, personId: String): PlainCallExecutable<BaseResult> {
        return setPersonsHome(homeId, listOf(personId))
    }

    /**
     * Returns the snapshot associated to an event.
     *
     * required scope: none required
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/getcamerapicture)
     *
     * @param imageId id of the image (can be retrieved as "id" in "face" in [getHomeData] for Welcome, or as "id" in "snapshot" in [getNextEvents], [io.rudolph.netatmo.api.security.SecurityConnector.getLastEventOf] and [getEventsUntil])
     * @param key Security key to access snapshots
     * @return an executable object to obtain the camera picture as jpg bytes wraped in [String] with size of  120x120
     */
    fun getCameraPicture(imageId: String, key: String): PlainCallExecutable<String> {
        return PlainCallExecutable {
            securityService.getCamerapPicture(imageId = imageId,
                    key = key)
        }
    }

    /**
     * Returns all the events until the one specified in the request.
     *
     * required scope: read_camera, access_camera, read_presence, access_presence
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/geteventsuntil)
     *
     * @param homeId ID of the Home you're interested in
     * @param eventId Your request will retrieve all the events until this one
     * @return an executable object to obtain the List of [Event]
     */
    fun getEventsUntil(homeId: String, eventId: String): BodyResultExecutable<Events> {
        return BodyResultExecutable {
            securityService.getEventsUntil(
                    homeId = homeId,
                    eventId = eventId)
        }
    }

    /**
     * Returns information about users homes and cameras.
     *
     * required scope: read_camera, access_camera, read_presence, access_presence
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/gethomedata)
     *
     * @param homeId ID of the Home you're interested in
     * @param eventId Your request will retrieve all the events until this one
     * @return an executable object to obtain the [SecurityHome]
     */
    @JvmOverloads
    fun getHomeData(homeId: String? = null, eventId: String? = null): BodyResultExecutable<SecurityHome> {
        return BodyResultExecutable {
            securityService.getHomeData(
                    homeId = homeId,
                    eventId = eventId)
        }
    }

    /**
     * Returns previous events.
     *
     * required scope: read_camera, access_camera, read_presence, access_presence
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/getnextevents)
     *
     * @param homeId ID of the Home you're interested in
     * @param eventId Your request will retrieve events occured before this one
     * @param size Number of event to retrieve. Default is 30.
     * @return an executable object to obtain the List of [Event]
     */
    @JvmOverloads
    fun getNextEvents(homeId: String, eventId: String, size: Int? = null): BodyResultExecutable<Events> {
        return BodyResultExecutable {
            securityService.getNextEvents(
                    homeId = homeId,
                    eventId = eventId,
                    size = size
            )
        }
    }

    /**
     * Links a callback url to a user.
     *
     * required scope: read_camera, read_presence
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/addwebhook)
     *
     * @param url Your webhook callback url
     * @param appTypes Webhooks are only available for Welcome and Presence, use app_security.
     * @return an executable object to obtain the [BaseResult]
     */
    fun addWebHook(url: String, appTypes: String): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            securityService.addWebHook(
                    url = url,
                    appTypes = appTypes)
        }
    }

    /**
     * Dissociates a webhook from a user.
     *
     * required scope: none required
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/dropwebhook)
     *
     * @return an executable object to obtain the [BaseResult]
     */
    fun dropWebHook(): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            securityService.dropWebHook()
        }
    }

    /**
     * Checks if application and Welcome/Presence camera are on the same local network
     *
     * required scope: access_camera, access_presence
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/gethomedata)
     *
     * @param url ID of the Home you're interested in
     * @return an executable object to obtain the [SecurityHome]
     */
    fun ping(url: String) = PlainCallExecutable { securityService.ping(url) }

    fun getLocalUrlAsync(camera: Camera, success: (String) -> Unit, error: (BackendError) -> Unit) {
        val url = camera.vpnUrl ?: error("no vpn url given")
        getLocalUrlAsync(url, success, error)
    }

    fun getLocalUrlAsync(camera: Camera, callback: Executable.Callback<String>) {
        val url = camera.vpnUrl ?: let {
            callback.onError(BackendError(0, "no vpn url given"))
            return
        }
        getLocalUrlAsync(url, {
            callback.onResult(it)
        }, {
            callback.onError(it)
        })
    }

    fun getLocalUrlAsync(url: String, success: (String) -> Unit, error: (BackendError) -> Unit) {
        ping(url).apply {
            onError(error).executeAsync {
                val newurl = it.localUrl ?: error("no new url retreived")
                ping(newurl).onError {
                    kotlin.error("cannot access camera")
                }.executeAsync {
                    it.localUrl?.apply {
                        if (this == newurl) {
                            success(this)
                        } else {
                            kotlin.error("result urls do not match")
                        }
                    } ?: apply {
                        error("camera ping error")
                    }
                }
            }
        }
    }

    private fun getLocalUrl(camera: Camera): String? {
        return camera.vpnUrl?.let {
            getLocalUrl(it)
        }
    }

    private fun getLocalUrl(url: String): String? {
        return ping(url).executeSync()
                ?.let {
                    val newUrl = it.localUrl ?: return null
                    ping(newUrl).executeSync()
                            ?.let { ping ->
                                ping.localUrl?.let { responseUrl ->
                                    if (responseUrl == newUrl) {
                                        responseUrl
                                    } else {
                                        null
                                    }
                                } ?: url
                            }
                }
    }

    fun getLiveSnapshotUrl(url: String): String? {
        return getLocalUrl(url)?.let {
            "$it/live/snapshot_720.jpg"
        }
    }

    fun getLiveSnapshotUrl(camera: Camera): String? {
        return getLocalUrl(camera)?.let {
            "$it/live/snapshot_720.jpg"
        }
    }

    fun getLiveSnapshotUrlAsync(camera: Camera, success: (String) -> Unit, error: (BackendError) -> Unit) {
        getLocalUrlAsync(camera, success, error)
    }

    fun getStreamingUrl(baseUrl: String) {
        getLocalUrl(baseUrl)?.let {
            "$it/live/index_local.m3u8"
        }
    }

    fun getStreamingUrl(camera: Camera) {
        getLocalUrl(camera)?.let {
            "$it/live/index_local.m3u8"
        }
    }

    fun getStreamingUrlAsync(camera: Camera, success: (String) -> Unit, error: (String) -> Unit) {
        val url = camera.vpnUrl ?: let {
            error("no vpn url given")
            return
        }
        getLocalUrlAsync(url, {
            success("$it/live/index_local.m3u8")
        }, {
            error("$url/live/index_local.m3u8")
        })
    }


    fun getStreamingUrlAsync(url: String, success: (String) -> Unit = {}, error: (String) -> Unit = {}) {
        getLocalUrlAsync(url, {
            success("$it/live/index_local.m3u8")
        }, {
            error("$url/live/index_local.m3u8")
        })
    }

    fun getStreamingUrlAsync(url: String, callback: Executable.Callback<String>) {
        getLocalUrlAsync(url, {
            callback.onResult(it)
        }, {
            callback.onError(it)
        })
    }

    fun getStreamingUrlAsync(camera: Camera, callback: Executable.Callback<String>) {
        getLocalUrlAsync(camera, { value: String -> callback.onResult(value) }, { value: BackendError -> callback.onError(value) })
    }


    fun getVodUrl(camera: Camera, videoId: String): String? {
        return getLocalUrl(camera)?.let {
            "$it/camera_url/vod/$videoId/index_local.m3u8"
        }
    }

    fun getVodUrlAsnyc(camera: Camera, videoId: String, success: (String) -> Unit, error: (BackendError) -> Unit) {
        getLocalUrlAsync(camera, {
            success("$this/camera_url/vod/$videoId/index_local.m3u8")
        }, error)
    }

    fun getVodUrlAsnyc(camera: Camera, videoId: String, callback: Executable.Callback<String>) {
        getLocalUrlAsync(camera, {
            callback.onResult("$it/camera_url/vod/$videoId/index_local.m3u8")
        }, {
            callback.onError(it)
        })
    }
}