package com.fakebook.api.controller

import com.fakebook.api.entity.Post
import com.fakebook.api.service.PostService
import jakarta.persistence.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(@Autowired private val postService: PostService) {

    @GetMapping("/getPosts")
    fun getAllPosts(): List<Post>{
        return postService.getAllPosts()
    }

    @PostMapping("/{id}/savePost")
    fun savePost(@PathVariable("id") id: Long, @RequestBody post: Post): Post{
        return postService.savePost(post, id)
    }

    @GetMapping("/getPost/{id}")
    fun getPost(@PathVariable("id") id: Long): Post{
    return postService.getPost(id)
    }


    @PutMapping("/update/{id}")
    fun updatePost(@PathVariable("id") id: Long, @RequestBody post: Post): Post{
        return postService.updatePost(id, post)
    }

    @DeleteMapping("/delete/{id}")
    fun deletePost(@PathVariable("id") id: Long){
        return postService.deletePost(id)
    }

}