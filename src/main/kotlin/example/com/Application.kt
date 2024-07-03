package example.com

import example.com.plugins.*
import io.ktor.server.application.*
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()

    val loggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
    val rootLogger = loggerContext.getLogger("org.mongodb.driver")
    val routeLogger = loggerContext.getLogger("io.ktor.routing.Routing")
    rootLogger.setLevel(Level.OFF)
    routeLogger.setLevel(Level.OFF)
    configureMongo()
}
