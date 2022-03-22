package edu.xfoleks.routes

import edu.xfoleks.data.model.RandomImage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.50.238:8100"
private val images = listOf(
    RandomImage("Car 1", "Speedy car", "$BASE_URL/images/car1.jpg"),
    RandomImage("Car 2", "Cool car", "$BASE_URL/images/car2.jpg"),
    RandomImage("Car 3", "Grey car", "$BASE_URL/images/car3.webp"),
    RandomImage("Car 4", "Car on route", "$BASE_URL/images/car4.jpeg"),
    RandomImage("Car 5", "Lamborghini is rules", "$BASE_URL/images/car5.webp")

)

fun Route.randomImage() {
    get("/randomcar") {
        call.respond(
          HttpStatusCode.OK,
          images.random()
        )
    }
}