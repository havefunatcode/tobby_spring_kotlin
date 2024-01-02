package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.domain.User
import jakarta.xml.bind.PropertyException
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
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
        val context: ApplicationContext = AnnotationConfigApplicationContext(DaoFactory::class.java)
        val userDao: UserDao = context.getBean("userDao", UserDao::class.java)

        val user = User("whiteship", "백기선", "married")

        userDao.add(user)
        println("\${user.id} 등록 성공")

        val user2 = userDao.get(user.id)
        if (user2 == null) return

        println(user2.name)
        println("\${user2.id} 조회 성공")
    }

}


