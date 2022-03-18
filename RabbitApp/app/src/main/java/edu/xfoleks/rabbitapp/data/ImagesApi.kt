package edu.xfoleks.rabbitapp.data

import edu.xfoleks.rabbitapp.data.RandomImage
import retrofit2.http.GET

interface ImagesApi {
    @GET("/randomimages")
    suspend fun getRandomImage(): RandomImage

    companion object {
        const val BASE_URL = "http://192.168.50.238:8080"
    }
}