package com.example.tobby_spring_kotlin.user.dao

class DaoFactory {

    fun userDao(dbUrl: String, driverUrl: String, username: String, password: String): UserDao =
        UserDao(connectionMaker(dbUrl, driverUrl, username, password))

    fun accountDao(dbUrl: String, driverUrl: String, username: String, password: String): AccountDao =
        UserDao(connectionMaker(dbUrl, driverUrl, username, password))

    fun messageDao(dbUrl: String, driverUrl: String, username: String, password: String): MessageDao =
        UserDao(connectionMaker(dbUrl, driverUrl, username, password))

    private fun connectionMaker(dbUrl: String, driverUrl: String, username: String, password: String): ConnectionMaker = DConnectionMaker(dbUrl, driverUrl, username, password)

}
