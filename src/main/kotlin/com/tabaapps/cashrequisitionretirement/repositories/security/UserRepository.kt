package com.tabaapps.cashrequisitionretirement.repositories.security

import com.tabaapps.cashrequisitionretirement.models.security.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUsername(username:String): Optional<User>
}