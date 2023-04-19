package com.fakebook.api.entity

import jakarta.persistence.*

@Entity
@Table(name = "follower")
data class Follower(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "follower_id")
    val follower: User,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
