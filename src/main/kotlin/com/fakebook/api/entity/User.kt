package com.fakebook.api.entity

import jakarta.persistence.*
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy

@Entity
@Table(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId : Long? =null,
    val username: String,
    val email: String,
    val bio: String? =null,
    val profilePictureUrl: String?=null
)
