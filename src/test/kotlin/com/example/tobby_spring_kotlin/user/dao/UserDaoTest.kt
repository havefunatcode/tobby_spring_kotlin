package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.config.TestConfig
import com.example.tobby_spring_kotlin.user.connection.*
import com.example.tobby_spring_kotlin.user.domain.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.core.env.*
import org.springframework.test.context.*

@SpringBootTest
@ActiveProfiles("mac")
@ContextConfiguration(classes = [TestConfig::class])
class UserDaoTest {

    @Autowired
    private lateinit var context: ApplicationContext

    @Test
    fun 등록_조회_테스트() {
        val userDao: UserDao = context.getBean("userDao", UserDao::class.java)

        val user = User("whiteship", "백기선", "married")
        userDao.add(user)
        println("${user.id} 등록 성공")

        val user2 = userDao.get(user.id)
        println(user2.name)
        println("${user2.id} 조회 성공")
    }

}
