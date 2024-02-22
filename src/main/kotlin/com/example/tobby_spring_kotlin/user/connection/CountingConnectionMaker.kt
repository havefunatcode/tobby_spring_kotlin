package com.example.tobby_spring_kotlin.user.connection

import java.sql.Connection

class CountingConnectionMaker(
    val realConnectionMaker: ConnectionMaker
): ConnectionMaker {
    private var count: Int = 0

    override fun makeConnection(): Connection {
        count++
        return realConnectionMaker.makeConnection()
    }

}
