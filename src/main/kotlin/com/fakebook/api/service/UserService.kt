package com.fakebook.api.service

import com.fakebook.api.entity.User
import com.fakebook.api.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserService(@Autowired private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun saveUsers(user: User): User {
        return userRepository.save(user)
    }

    fun getUser(userId: Long): User {
        val user = userRepository.findById(userId).orElse(null)

        return userRepository.findById(userId)

            .orElseThrow { EntityNotFoundException("User not found with ID: $userId") }

    }
    fun deleteUser(id: Long? ){
        if(id!=null){
            if(userRepository.existsById(id))   {
                userRepository.deleteById(id)
            }
            else
                throw EntityNotFoundException("User not found with ID: $id")

        }
        else throw IllegalArgumentException("Id must not be null")

    }

    fun updateUser(id: Long, user: User) : User {

        val existingUser = userRepository.findById(id).orElse(null)

        val updatedUser = existingUser.copy(
            username = user.username,
            email = user.email,
            bio = user.bio,
            profilePictureUrl = user.profilePictureUrl
        )

return userRepository.save(updatedUser)

    }
}