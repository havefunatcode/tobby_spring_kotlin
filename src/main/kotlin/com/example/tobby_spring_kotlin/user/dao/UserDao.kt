package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.annotation.NoArg
import com.example.tobby_spring_kotlin.user.domain.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.sql.DriverManager
import java.sql.SQLException

@NoArg
@Component
class UserDao(
    @Value("\${spring.datasource.url}")
    private val dbUrl: String,
    @Value("\${spring.datasource.driver-class-name}")
    private val driverUrl: String,
    @Value("\${spring.datasource.username}")
    private val username: String,
    @Value("\${spring.datasource.password}")
    private val password: String
) {

    fun add(user: User) {
        try {
            Class.forName(driverUrl)
            val connection = DriverManager.getConnection(dbUrl, username, password)
            val preparedStatement = connection.prepareStatement("insert into user(id, name, password) value(?,?,?)")
            preparedStatement.setString(1, user.id)
            preparedStatement.setString(2, user.name)
            preparedStatement.setString(3, user.password)

            preparedStatement.executeUpdate()

            preparedStatement.close()
            connection.close()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun get(id: String): User? {
        try {
            Class.forName(driverUrl)
            val connection = DriverManager.getConnection(dbUrl, username, password)
            val preparedStatement = connection.prepareStatement("select * from tobby_spring.USER where id = ?")
            preparedStatement.setString(1, id)

            val resultSet = preparedStatement.executeQuery()
            resultSet.next()

            val user = User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"))

            resultSet.close()
            preparedStatement.close()
            connection.close()

            return user
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null
    }

}