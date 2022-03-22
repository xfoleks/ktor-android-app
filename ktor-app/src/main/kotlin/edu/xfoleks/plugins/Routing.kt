package edu.xfoleks.plugins

import edu.xfoleks.routes.randomImage
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        randomImage()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}
