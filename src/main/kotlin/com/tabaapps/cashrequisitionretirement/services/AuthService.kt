package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.security.Role
import com.tabaapps.cashrequisitionretirement.models.security.User
import com.tabaapps.cashrequisitionretirement.models.security.UserRole
import com.tabaapps.cashrequisitionretirement.repositories.security.RoleRepository
import com.tabaapps.cashrequisitionretirement.repositories.security.UserRepository
import com.tabaapps.cashrequisitionretirement.repositories.security.UserRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AuthService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userRoleRepository: UserRoleRepository

    @Autowired
    private lateinit var roleRepository: RoleRepository

    fun saveUser(id: Long?, user: User): User {
        if (id == null) {
            user.createdAt = LocalDateTime.now()
            return userRepository.save(user)
        }
        val savedUser = userRepository.findById(id).orElseThrow { Exception("User is not found") }
        savedUser.updatedAt = LocalDateTime.now()
        return userRepository.save(savedUser)
    }

    fun viewUser(id: Long): User {
        return userRepository.findById(id).orElseThrow { Exception("User is not found") }
    }

    fun assignRoles(id: Long, roleIds: List<Long>): List<Role> {
        val user = userRepository.findById(id).orElseThrow { Exception("User is not found") }
        val roles = roleRepository.findAllById(roleIds)
        val userRoles = roles.map {
            userRoleRepository.findByUserAndRole(user, role = it)
                .orElse(UserRole(user = user, role = it, isActive = true))
        }
        userRoleRepository.saveAll(userRoles)
        return userRoles.map { it.role }
    }

    fun removeRoles(id: Long, roleIds: List<Long>): List<Role> {
        val user = userRepository.findById(id).orElseThrow { Exception("User is not found") }
        val roles = roleRepository.findAllById(roleIds)
        val userRoles = roles.map {
            userRoleRepository.findByUserAndRole(user, role = it)
                .orElse(UserRole(user = user, role = it, isActive = true))
        }
        userRoleRepository.deleteAll(userRoles)
        return userRoles.map { it.role }
    }
}