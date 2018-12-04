package apitest

import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.ClimateModule
import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Forecast
import io.rudolph.netatmo.api.weather.model.Station
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class WeatherTest : BaseTest(listOf(Scope.READ_STATION, Scope.WRITE_THERMOSTAT, Scope.READ_THERMOSTAT)) {

    val connector = api.weatherApi

    @Test
    fun parsingTest() {
        readFileForClass<TypedBaseResult<List<Station>>>("/apiresults/weather/getPublicData.json")!!
        readFileForClass<TypedBaseResult<Forecast>>("/apiresults/weather/getSimpleForecast.json")!!
        readFileForClass<TypedBaseResult<StationResults>>("/apiresults/weather/StationDataResponse.json")!!
    }


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
            val moduleId = devices[0].modules?.get(0)?.id!!
            connector.getSimpleForecast(deviceId, moduleId).executeSyncWrapped().apply {
                assert(this != null)
            }
        }
    }
}