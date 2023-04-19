package com.fakebook.api.service

import com.fakebook.api.entity.Post
import com.fakebook.api.entity.User
import com.fakebook.api.repository.PostRepository
import com.fakebook.api.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PostService(@Autowired private val postRepository: PostRepository, @Autowired private val userRepository: UserRepository) {

    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }


    fun savePost(post: Post, userId: Long): Post {
        var user = userRepository.findById(userId).orElseThrow{IllegalArgumentException("invalid user Id")}
        post.user = user
        return postRepository.save(post)
    }

    fun getPost(postId: Long): Post {
        val post = postRepository.findById(postId).orElse(null)

        return postRepository.findById(postId)

            .orElseThrow { EntityNotFoundException("Post not found with ID: $postId") }

    }

    fun deletePost(id: Long){
        if(postRepository.existsById(id)){
            postRepository.deleteById(id)
        }
        else{
            throw EntityNotFoundException("Post Not found")
        }
    }

    fun updatePost( id: Long, post: Post): Post{
        val existingPost = postRepository.findById(id).orElse(null)
        val updatedPost = existingPost.copy(
            text = post.text,
            postImgUrl = post.postImgUrl,
            createdAt = LocalDateTime.now()
        )

        return postRepository.save(updatedPost)

    }



    }