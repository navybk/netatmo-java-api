package io.rudolph.netatmo.api.presence

import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.presence.model.Camera
import io.rudolph.netatmo.api.presence.model.Event
import io.rudolph.netatmo.api.presence.model.Events
import io.rudolph.netatmo.api.presence.model.SecurityHome
import io.rudolph.netatmo.api.presence.service.PresenceService
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.executable.Executable
import io.rudolph.netatmo.executable.PlainCallExecutable
import io.rudolph.netatmo.oauth2.model.BackendError
import retrofit2.Retrofit

open class PresenceConnector(api: Retrofit) : CommonConnector(api) {
    private val presenceService = api.create(PresenceService::class.java)

    /**
     * Returns the snapshot associated to an event.
     *
     * required scope: none required
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/security/getcamerapicture)
     *
     * @param imageId id of the image (can be retrieved as "id" in "face" in [getHomeData] for Welcome, or as "id" in "snapshot" in [getNextEvents], [io.rudolph.netatmo.api.welcome.WelcomeConnector.getLastEventOf] and [getEventsUntil])
     * @param key Security key to access snapshots
     * @return an executable object to obtain the camera picture as jpg bytes wraped in [String] with size of  120x120
     */
    fun getCameraPicture(imageId: String, key: String): PlainCallExecutable<String> {
        return PlainCallExecutable {
            presenceService.getCamerapPicture(imageId = imageId,
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
            presenceService.getEventsUntil(
                    accessToken = "",
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
    fun getHomeData(homeId: String? = null, eventId: String? = null): BodyResultExecutable<SecurityHome> {
        return BodyResultExecutable {
            presenceService.getHomeData(
                    accessToken = "",
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
    fun getNextEvents(homeId: String, eventId: String, size: Int? = null): BodyResultExecutable<Events> {
        return BodyResultExecutable {
            presenceService.getNextEvents(
                    accessToken = "",
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
            presenceService.addWebHook(
                    accessToken = "",
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
     * @param appTypes For Welcome and Presence, use app_security
     * @return an executable object to obtain the [BaseResult]
     */
    fun dropWebHook(appTypes: String): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            presenceService.dropWebHook(
                    accessToken = " ",
                    appTypes = appTypes)
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
    fun ping(url: String) = PlainCallExecutable { presenceService.ping(url) }

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