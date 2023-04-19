package com.fakebook.api.controller

import com.fakebook.api.entity.Comment
import com.fakebook.api.service.CommentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("comment")
class CommentController(private val commentService: CommentService) {

    @GetMapping("getComments")
    fun getComments():List<Comment>{
        return commentService.getAllComments()
    }


}