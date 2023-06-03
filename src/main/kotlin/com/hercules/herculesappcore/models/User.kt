package com.hercules.herculesappcore.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*


@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "user_id", nullable = false)
    var userId: String,

    @Column(name = "username", nullable = false)
    var username: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "firstname", nullable = false)
    var firstname: String,

    @Column(name = "lastname", nullable = false)
    var lastname: String,

    @Column(name = "profile_image", nullable = true)
    var profileImage: String,

    @CreationTimestamp
    var createdAt: Date,

    @UpdateTimestamp
    var updatedAt: Date,

    @Column(name = "pin_code", nullable = false)
    var pinCode: String,

    @Column(name = "token", nullable = false)
    var token: String
)