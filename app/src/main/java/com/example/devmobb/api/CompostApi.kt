package com.example.devmobb.api

import Compost
import retrofit2.Response
import retrofit2.http.GET

interface CompostApi {
    @GET("api/composts")
    suspend fun getComposts(): Response<List<Compost>>
}