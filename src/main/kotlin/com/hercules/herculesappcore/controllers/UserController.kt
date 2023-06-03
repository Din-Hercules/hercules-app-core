package com.hercules.herculesappcore.controllers

import com.hercules.herculesappcore.models.User
import com.hercules.herculesappcore.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://127.0.0.1:12629"])
@RestController
@RequestMapping("/api/v1")
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(userService.findAllUsers(), HttpStatus.OK)
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user: User): ResponseEntity<HttpStatus> {
        userService.saveUser(user)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/user/{id}")
    fun updateUser(@PathVariable("id") id: Long, @Validated @RequestBody body: User): User {
        return userService.updateUser(body, id)
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Map<String, String>> {
        return userService.deleteUser(id)
    }
}