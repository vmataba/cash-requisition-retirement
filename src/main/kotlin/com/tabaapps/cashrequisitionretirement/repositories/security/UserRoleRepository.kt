package com.tabaapps.cashrequisitionretirement.repositories.security

import com.tabaapps.cashrequisitionretirement.models.security.Role
import com.tabaapps.cashrequisitionretirement.models.security.User
import com.tabaapps.cashrequisitionretirement.models.security.UserRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRoleRepository : JpaRepository<UserRole, Long> {

    fun findByUserAndRole(user:User,role:Role): Optional<UserRole>
}