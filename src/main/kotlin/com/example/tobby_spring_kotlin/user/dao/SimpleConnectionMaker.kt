package com.example.tobby_spring_kotlin.user.dao

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

@Component
class SimpleConnectionMaker(
    @Value("\${spring.datasource.url}")
    private val dbUrl: String,
    @Value("\${spring.datasource.driver-class-name}")
    private val driverUrl: String,
    @Value("\${spring.datasource.username}")
    private val username: String,
    @Value("\${spring.datasource.password}")
    private val password: String
) {
    @Throws(ClassNotFoundException::class, SQLException::class)
    fun getConnection(): Connection {
        Class.forName(driverUrl)
        return DriverManager.getConnection(dbUrl, username, password)
    }
}