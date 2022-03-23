package edu.xfoleks.imageapp.data

import retrofit2.http.GET

interface ImagesApi {
    @GET("/randomcar")
    suspend fun getRandomImage(): RandomImage

    companion object {
        const val BASE_URL = "http://192.168.50.238:8080"
    }
}