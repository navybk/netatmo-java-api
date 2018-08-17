package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.ClimateModule
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Forecast
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class WeatherTest : BaseTest(listOf(Scope.READ_STATION, Scope.WRITE_THERMOSTAT, Scope.READ_THERMOSTAT)) {

    val connector = api.weatherApi

    @Test
    fun getPublicData() {
        connector.getPublicData(
                latitudeNorthEast = 10F,
                longitudeNorthEast = 10F,
                latitudeSouthWest = -10F,
                longitudeSouthWest = -10F)
                .executeSync().apply {
                    assert(this != null)
                }
    }

    @Test
    fun getStationData() {
        connector.getStationData().executeSync()?.apply {
            assert(this.user.mail != null)
            devices[0].modules?.forEach {
                val batteryLevel = (it as? ClimateModule)?.getBatteryState
                assert(batteryLevel != BatteryState.NO_DATA)
            }
            return
        }
        assert(false)
    }

    @Test
    fun getForecast() {
        connector.getStationData().executeSync()?.apply {
            val deviceId = devices[0].id!!
            val moduleId = devices[0]?.modules?.get(0)?.id!!
            connector.getSimpleForecast(deviceId, moduleId).executeSyncWrapped().apply {
                assert(this != null)
            }
        }
    }

    @Test
    fun parseForecastXML() {
        val stream = TestConfig::class.java.getResourceAsStream("/apiresults/weather/getSimpleForecast.json").bufferedReader()
        val reference = object : TypeReference<TypedBaseResult<Forecast>>() {}
        val forecast = JacksonTransform.mapper.readValue<TypedBaseResult<Forecast>>(stream, reference)
        assert(forecast != null)
    }

}