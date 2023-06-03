package com.hercules.herculesappcore.services

import com.hercules.herculesappcore.models.User
import com.hercules.herculesappcore.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
    @Autowired
    private lateinit var userRepo: UserRepository

    fun findAllUsers(): List<User> {
        return userRepo.findAll()
    }

    fun findAUser(id: Long): Optional<User> {
        return userRepo.findById(id)
    }

    fun saveUser(user: User): User {
        return userRepo.save(user)
    }

    fun updateUser(user: User, id: Long): User {
        return try {
            val newUser: User = userRepo.getReferenceById(id)
            newUser.userId = user.userId
            newUser.username = user.username
            newUser.email = user.email
            newUser.password = user.password
            newUser.username = user.firstname
            newUser.username = user.lastname
            newUser.username = user.profileImage
            newUser.username = user.pinCode
            userRepo.save(newUser)
        } catch (e: Exception) {
            throw Exception("Unable to update data with id $id")
        }
    }

    fun deleteUser(id: Long): ResponseEntity<Map<String, String>> {
        return try {
            userRepo.deleteById(id)
            val response: MutableMap<String, String> = HashMap()
            response["data"] = "Properly Removed"
            ResponseEntity.ok(response)
        } catch (e: Exception) {
            throw e
        }
    }
}