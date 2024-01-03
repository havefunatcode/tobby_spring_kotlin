package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.connection.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DaoFactory(
    @Value("\${spring.datasource.url}")
    private val dbUrl: String,
    @Value("\${spring.datasource.driver-class-name}")
    private val driverUrl: String,
    @Value("\${spring.datasource.username}")
    private val username: String,
    @Value("\${spring.datasource.password}")
    private val password: String
) {

    @Bean
    fun userDao(): UserDao = UserDao(connectionMaker(dbUrl, driverUrl, username, password))

//    fun accountDao(dbUrl: String, driverUrl: String, username: String, password: String): AccountDao =
//        UserDao(connectionMaker(dbUrl, driverUrl, username, password))

//    fun messageDao(dbUrl: String, driverUrl: String, username: String, password: String): MessageDao =
//        UserDao(connectionMaker(dbUrl, driverUrl, username, password))

    private fun connectionMaker(dbUrl: String, driverUrl: String, username: String, password: String): ConnectionMaker = DConnectionMaker(dbUrl, driverUrl, username, password)

}
