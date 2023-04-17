package com.example.tobby_spring_kotlin.user.dao

import io.github.cdimascio.dotenv.Dotenv
import jakarta.annotation.PostConstruct
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.TestPropertySource

@TestPropertySource("classpath:application.yml")
@TestConfiguration
class TestConfig {
    @PostConstruct
    fun init() {
        Dotenv.configure().filename(".env.properties").systemProperties().load()
    }
}