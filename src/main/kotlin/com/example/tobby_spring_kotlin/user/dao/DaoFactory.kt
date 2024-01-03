package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.connection.*

class DaoFactory(
    private val driverClassName: String,
    private val dbUrl: String,
    private val username: String,
    private val password: String
) {

    fun userDao(): UserDao = UserDao(connectionMaker())

//    fun accountDao(dbUrl: String, driverUrl: String, username: String, password: String): AccountDao = AccountDao(connectionMaker())

//    fun messageDao(dbUrl: String, driverUrl: String, username: String, password: String): MessageDao = MessageDao(connectionMaker())

    private fun connectionMaker(): ConnectionMaker = DConnectionMaker(driverClassName, dbUrl, username, password)

}
