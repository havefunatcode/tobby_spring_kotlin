package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.domain.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import java.sql.SQLException

@SpringBootTest
class UserNoArgTest {

    @Value("\${spring.datasource.url}")
    private lateinit var dbUrl: String
    @Value("\${spring.datasource.driver-class-name}")
    private lateinit var driverUrl: String
    @Value("\${spring.datasource.username}")
    private lateinit var id: String
    @Value("\${spring.datasource.password}")
    private lateinit var password: String

    @Test
    fun daoTest() {
        try {
            val userDao = UserDao(dbUrl, driverUrl, id, password)
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