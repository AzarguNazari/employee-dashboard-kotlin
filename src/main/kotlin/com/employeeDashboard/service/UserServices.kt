package com.employeeDashboard.service

import com.employeeDashboard.User
import com.employeeDashboard.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) : DAO<User> {

    override fun save(t: User) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, t: User) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<User> {
        TODO("Not yet implemented")
    }
}