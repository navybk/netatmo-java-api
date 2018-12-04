# Netatmo Kotlin/Java Api

Authorize and connect to the [Netatmo API](https://dev.netatmo.com/resources/technical/introduction).

All you need are your login credentials from https://auth.netatmo.com/access/checklogin and ClientId/Client-Secret from https://dev.netatmo.com/myaccount/createanapp

No OAuth2 handling is needed, the lib will login and refresh the credentials automatically

## Using the lib

Initialize the lib with your credentials

```java
List<Scope> scopeList = new ArrayList<Scope>();
list.add(Scope.ACCESS_PRESENCE);
NetatmoApi api = new NetatmoApi("$USERNAME", "$USERPASSWORD", "CLIENTID", "CLIENTSECRET", scopeList)
```

If you already have access token and refresh token, which is accessible from the NetatmoApi-Object after the first successfull call, you may add them after the cope list. It will prevent the lib to relogin.

For debug information simply add the debug flag as boolean parameter to the constructor.

### Examples

For retreiving data, you have to specify the Netatmo Api Connector (weather, energy, aircare, etc.) and method.

```java
Executable<HomesDataBody> getHomesDataExec = api.getEnergyApi().getHomesData(null, null)
```
In return you get an executable with is capable of synchronous and/or asynchronous execution.

#### Synchronous
```java
HomesDataBody result = getHomesDataExec.executeSync()
```

The result is either the model or null or the actual object. Error values are only printed when debug is activated

#### Asynchronous
```java
Executable.Callback<HomesDataBody> callback = new Executable.Callback<HomesDataBody>() {
    @Override
    public void onResult(HomesDataBody homesDataBody) {

    }

    @Override
    public void onError(BackendError s) {

    }
};
api.getEnergyApi().getHomesData(null, null).executeAsync(callback);
```

The call will either return the object in the `onResult` function or an error in `OnError` function

Also lambdas are possible
```java
{
    […]
    api.getEnergyApi().getHomesData(null, null)
            .onError(this::onError)
            .executeAsync(this::onSuccess);
    […]
}

public Unit onError(BackendError error){
    return null;
}

public Unit onSuccess(HomesDataBody obj) {
    return null;
}
```
Be aware of the return types (caused by Kotlin <-> Java interface )

For the most convinient usage, Kotlin is advised

## Used libraries
* [Kotlin 1.3](https://github.com/JetBrains/kotlin/)
* [Kotlin Coroutines 1.0.1](https://github.com/Kotlin/kotlinx.coroutines)
* [Kotlin Logging 1.6.22](https://github.com/MicroUtils/kotlin-logging)
* [Kotlin Coroutine Adapter 0.9.2](https://github.com/JakeWharton/retrofit2-kotlin-coroutines-adapter)
*  [Retrofit 2.5.0](https://github.com/square/retrofit)
*  [Jackson Converter 2.5.0](https://github.com/square/retrofit/tree/master/retrofit-converters/jackson)
*  [Jackson Core 2.9.7](https://github.com/FasterXML/jackson-core)
*  [Jackson Annotations 2.9.7](https://github.com/FasterXML/jackson-annotations)
* [Jackson Kotlin Module 2.9.7](https://github.com/FasterXML/jackson-module-kotlin)
* [OkHttp 3.12.0](https://github.com/square/okhttp)
* [OkHttp Loggin Interceptor 3.12.0](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)

## Authors

* **Michael Rudolph** - *Initial work*

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
