package com.fakebook.api.controller

import com.fakebook.api.entity.User
import com.fakebook.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/fakeboot")
    class UserController(@Autowired private val userService: UserService) {

        @GetMapping("/getUsers")
            fun getUsers(): List<User> {
                return userService.getAllUsers()
            }

        @PostMapping("/saveUser")
        fun saveUser(@RequestBody user: User ): User{
            return userService.saveUsers(user)
            }

        @GetMapping("getUser/{id}")
        fun getUser(@PathVariable("id") id: Long): User{
            return userService.getUser(id)
        }

        @DeleteMapping("/delete/{id}")
        fun deleteUser(@PathVariable("id") id: Long){
            userService.deleteUser(id)
        }

        @PutMapping("update/{id}")
        fun updateUser(@PathVariable("id") id: Long, @RequestBody user: User): User{

            return userService.updateUser(id, user)

        }



}

