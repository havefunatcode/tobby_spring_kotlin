package com.example.tobby_spring_kotlin.user.dao

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.DriverManager

@Component
class DConnectionMaker(
    @Value("\${spring.datasource.url}")
    private val dbUrl: String,
    @Value("\${spring.datasource.driver-class-name}")
    private val driverUrl: String,
    @Value("\${spring.datasource.username}")
    private val username: String,
    @Value("\${spring.datasource.password}")
    private val password: String
): ConnectionMaker {

    override fun makeConnection(): Connection {
        Class.forName(driverUrl)
        return DriverManager.getConnection(dbUrl, username, password)
    }

}