package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.ClimateModule
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Forecast
import org.junit.Test

class WeatherTest : BaseTest() {

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
    fun parseForecastXML() {
        val stream = Forecast::class.java.getResourceAsStream("/apiresults/weather/getSimpleForecast.json").bufferedReader()
        val reference = object : TypeReference<TypedBaseResult<Forecast>>() {}
        val forecast = JacksonTransform.mapper.readValue<TypedBaseResult<Forecast>>(stream, reference)
        assert(forecast != null)
    }

}