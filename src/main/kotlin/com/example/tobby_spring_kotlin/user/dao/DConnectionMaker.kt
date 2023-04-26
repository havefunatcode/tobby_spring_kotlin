package com.example.tobby_spring_kotlin.user.dao

import java.sql.Connection
import java.sql.DriverManager

class DConnectionMaker(
    private val dbUrl: String,
    private val driverUrl: String,
    private val username: String,
    private val password: String
): ConnectionMaker {

    override fun makeConnection(): Connection {
        Class.forName(driverUrl)
        return DriverManager.getConnection(dbUrl, username, password)
    }

}