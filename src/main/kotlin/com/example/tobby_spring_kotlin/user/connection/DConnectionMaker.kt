package com.example.tobby_spring_kotlin.user.connection

import java.sql.Connection
import java.sql.DriverManager

class DConnectionMaker(
    private val driverClassName: String,
    private val dbUrl: String,
    private val username: String,
    private val password: String
): ConnectionMaker {

    override fun makeConnection(): Connection {
        Class.forName(driverClassName)
        return DriverManager.getConnection(dbUrl, username, password)
    }

}
