package com.example.diandroid.data

import retrofit2.http.GET

interface ApiInterface {

    @GET("fact")
    suspend fun getFact() : FactData
}