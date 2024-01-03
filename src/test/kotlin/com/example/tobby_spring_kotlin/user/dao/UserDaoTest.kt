package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.connection.*
import com.example.tobby_spring_kotlin.user.domain.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.*
import org.springframework.test.context.*

@SpringBootTest
@ActiveProfiles("mac")
@ContextConfiguration(classes = [TestConfig::class])
class UserDaoTest {

    @Value("\${spring.datasource.driver-class-name}")
    private lateinit var driverClassName: String
    @Value("\${spring.datasource.url}")
    private lateinit var dbUrl: String
    @Value("\${spring.datasource.username}")
    private lateinit var username: String
    @Value("\${spring.datasource.password}")
    private lateinit var password: String

    @Test
    fun noArgTest() {
        val connectionMaker: ConnectionMaker = DConnectionMaker(driverClassName, dbUrl, username, password)
        val userDao: UserDao = UserDao(connectionMaker)

        val user = User("whiteship", "백기선", "married")
        userDao.add(user)
        println("\${user.id} 등록 성공")

        val user2 = userDao.get(user.id)
        println(user2.name)
        println("\${user2.id} 조회 성공")
    }

}
