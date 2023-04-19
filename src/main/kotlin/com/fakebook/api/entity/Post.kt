package com.fakebook.api.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "post")
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long?=null,
    val text: String,
    val postImgUrl: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    var user:User?
)
