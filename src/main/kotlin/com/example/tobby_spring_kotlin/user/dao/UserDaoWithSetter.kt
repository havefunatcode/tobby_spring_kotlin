package com.example.tobby_spring_kotlin.user.dao

import com.example.tobby_spring_kotlin.user.connection.*
import com.example.tobby_spring_kotlin.user.domain.User
import org.springframework.util.ObjectUtils
import java.sql.Connection
import java.sql.SQLException

class UserDaoWithSetter {
    private lateinit var connectionMaker: ConnectionMaker

    fun setConnectionMaker(connectionMaker: ConnectionMaker) {
        this.connectionMaker = connectionMaker
    }

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun add(user: User) {
        val connection = connectionMaker.makeConnection()
        val preparedStatement = connection.prepareStatement("insert into user(id, name, password) value(?,?,?)")
        preparedStatement.setString(1, user.id)
        preparedStatement.setString(2, user.name)
        preparedStatement.setString(3, user.password)

        preparedStatement.executeUpdate()

        preparedStatement.close()
        connection.close()
    }

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun get(id: String): User {
        val connection = connectionMaker.makeConnection()
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
