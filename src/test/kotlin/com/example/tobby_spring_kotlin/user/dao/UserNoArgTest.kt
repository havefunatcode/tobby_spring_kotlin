package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.domain.User
import jakarta.xml.bind.PropertyException
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import java.sql.SQLException

@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
@ActiveProfiles("mac")
class UserNoArgTest {
    @Autowired
    private lateinit var env: Environment

    @Test
    @Throws(ClassNotFoundException::class, SQLException::class)
    fun daoTest() {
        val dbUrl = env.getProperty("spring.datasource.url") ?: throw PropertyException("There's no property in Context!")
        val driverUrl = env.getProperty("spring.datasource.driver-class-name") ?: throw PropertyException("There's no property in Context!")
        val username = env.getProperty("spring.datasource.username") ?: throw PropertyException("There's no property in Context!")
        val password = env.getProperty("spring.datasource.password") ?: throw PropertyException("There's no property in Context!")
        val userDao = DaoFactory().userDao(dbUrl, driverUrl, username, password)

        val user = User("whiteship", "백기선", "married")

        userDao.add(user)
        println("\${user.id} 등록 성공")

        val user2 = userDao.get(user.id)
        if (user2 == null) return

        println(user2.name)
        println("\${user2.id} 조회 성공")
    }

}


