package com.example.tobby_spring_kotlin.user.dao

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
class EnvTest {
    @Autowired
    private lateinit var env: Environment

    @Test
    fun test() {
        val username = env.getProperty("spring.datasource.username")
        val password = env.getProperty("spring.datasource.password")

        println(username)
        println(password)
    }
}