package com.fakebook.api.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comment")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long?=null,
    val commentText: String,

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    var user: User?,

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "post_id",
        referencedColumnName = "postId"
    )
    var post: Post?,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
