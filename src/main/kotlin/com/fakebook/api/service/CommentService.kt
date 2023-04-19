package com.fakebook.api.service

import com.fakebook.api.entity.Comment
import com.fakebook.api.repository.CommentRepository
import com.fakebook.api.repository.PostRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService(private val postRepository: PostRepository, @Autowired private val commentRepository: CommentRepository) {

    fun getAllComments() : List<Comment>{
        return commentRepository.findAll()
    }

   fun saveComment(postId: Long, comment: Comment): Comment{
       val post = postRepository.findById(postId).orElseThrow{IllegalArgumentException("invalid user Id")}

       comment.post=post

       return commentRepository.save(comment)
   }

    fun getComment(id: Long): Comment{
        val comment = commentRepository.findById(id).orElseThrow{IllegalArgumentException("invalid id passed")}
        if(comment!=null){
            return comment
        }
        else{
            throw EntityNotFoundException("cannot find the comment")
        }
    }

    fun deleteComment(id: Long){
        if(commentRepository.existsById(id)){
            commentRepository.deleteById(id)
        }
        else{
            throw EntityNotFoundException("Post Not found")
        }
    }
}