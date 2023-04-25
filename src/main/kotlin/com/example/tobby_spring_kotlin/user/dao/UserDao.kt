package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.annotation.NoArg
import com.example.tobby_spring_kotlin.user.domain.User
import org.springframework.stereotype.Component
import java.sql.SQLException

@NoArg
@Component
class UserDao(
    private val simpleConnectionMaker: SimpleConnectionMaker
) {

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun add(user: User) {
        val connection = simpleConnectionMaker.getConnection()
        val preparedStatement = connection.prepareStatement("insert into user(id, name, password) value(?,?,?)")
        preparedStatement.setString(1, user.id)
        preparedStatement.setString(2, user.name)
        preparedStatement.setString(3, user.password)

        preparedStatement.executeUpdate()

        preparedStatement.close()
        connection.close()
    }

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun get(id: String): User? {
        val connection = simpleConnectionMaker.getConnection()
        val preparedStatement = connection.prepareStatement("select * from tobby_spring.USER where id = ?")
        preparedStatement.setString(1, id)

        val resultSet = preparedStatement.executeQuery()
        resultSet.next()

        val user = User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"))

        resultSet.close()
        preparedStatement.close()
        connection.close()

        return user
    }

}