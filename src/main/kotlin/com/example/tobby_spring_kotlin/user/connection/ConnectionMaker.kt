package com.example.tobby_spring_kotlin.user.connection

import java.sql.Connection
import java.sql.SQLException

interface ConnectionMaker {

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun makeConnection() : Connection

}
