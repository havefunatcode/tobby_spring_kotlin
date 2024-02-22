package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.connection.ConnectionMaker
import com.example.tobby_spring_kotlin.user.connection.DConnectionMaker
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SetterDaoFactory(
    @Value("\${spring.datasource.driver-class-name}")
    private val driverClassName: String,
    @Value("\${spring.datasource.url}")
    private val dbUrl: String,
    @Value("\${spring.datasource.username}")
    private val username: String,
    @Value("\${spring.datasource.password}")
    private val password: String
) {

    @Bean
    fun userDao(): UserDaoWithSetter = UserDaoWithSetter().apply { setConnectionMaker(connectionMaker()) }

    @Bean
    fun connectionMaker(): ConnectionMaker = DConnectionMaker(driverClassName, dbUrl, username, password)

}
