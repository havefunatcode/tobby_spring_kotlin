package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.domain.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import java.sql.SQLException

@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
class UserNoArgTest {

    @Autowired
    private lateinit var userDao: UserDao

    @Test
    fun daoTest() {
        try {
            val user = User("whiteship", "백기선", "married")

            userDao.add(user)
            println("\${user.id} 등록 성공")

            val user2 = userDao.get(user.id)
            if (user2 == null) return

            println(user2.name)
            println("\${user2.id} 조회 성공")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}