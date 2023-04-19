//package com.fakebook.api.entity
//
//import jakarta.persistence.Entity
//import jakarta.persistence.JoinColumn
//import jakarta.persistence.OneToOne
//import jakarta.persistence.Table
//
//@Entity
//@Table(name = "follow")
//data class Follow(
//    val followId: Long? =null,
//
//    @OneToOne()
//    @JoinColumn(
//        name = "follower",
//        referencedColumnName = "userId"
//    )
//    val followerId: User,
//    @OneToOne()
//    @JoinColumn(
//        name = "following",
//        referencedColumnName = "userId"
//    )
//    val followingId: User
//)
