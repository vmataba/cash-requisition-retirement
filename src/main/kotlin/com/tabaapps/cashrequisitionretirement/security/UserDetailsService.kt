package com.tabaapps.cashrequisitionretirement.security

import com.tabaapps.cashrequisitionretirement.repositories.security.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService : UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username).orElseThrow { ResponseException("Incorrect username or password") }
        return User.withUsername(user.username)
            .password(user.password)
            .roles(user.roles.toString())
            .build()
    }
}