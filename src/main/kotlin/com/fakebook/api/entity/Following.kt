package com.fakebook.api.entity

import jakarta.persistence.*

@Entity
@Table(name = "following")
data class Following(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "following_id")
    val following: User,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
