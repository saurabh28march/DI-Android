package com.example.diandroid.example

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class Engine @Inject constructor() {

    fun start() {
        Log.d("mytag", "engine....")
    }

}

class Wheel @Inject constructor() {

    fun start() {
        Log.d("mytag", "wheels...")
    }
}

class Car @Inject constructor(private val engine: Engine, private val wheel: Wheel) {
    fun start() {
        engine.start()
        wheel.start()
        Log.d("tag", "car is runnig")
    }
}

interface API {
    fun getNetworkResult()
}

class ImplAPI @Inject constructor() : API {
    override fun getNetworkResult() {
        Log.e("tag","get work")
    }
}

class Main @Inject constructor(private val api : API,
                               @Named("Lname")
                               private val name : String){
    fun getResult(){
        name.toIntOrNull()
        api.getNetworkResult()
    }
}

//Use this Method for Interface Injection
/* this is better -> less boiler plate code
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun getApi(
        api : ImplAPI
    ) : API
}
*/


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesAPI() : API = ImplAPI()

    @Provides
    @Singleton
    @Named("fname")
    fun provideFname() : String = "fname"

    @Provides
    @Singleton
    @Named("Lname")
    fun provideLname() : String = "Lname"
}
