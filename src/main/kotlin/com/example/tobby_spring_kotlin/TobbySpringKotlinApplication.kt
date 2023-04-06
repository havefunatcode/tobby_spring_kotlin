package com.example.tobby_spring_kotlin

import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment
import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class TobbySpringKotlinApplication

fun main(args: Array<String>) {
    Dotenv.configure().filename(".env.properties").systemProperties().load()
    SpringApplicationBuilder()
        .environment(StandardEncryptableEnvironment())
        .sources(TobbySpringKotlinApplication::class.java)
        .run(*args)
}
