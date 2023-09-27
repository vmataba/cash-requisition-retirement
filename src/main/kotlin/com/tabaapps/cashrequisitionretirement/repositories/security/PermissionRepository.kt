package com.tabaapps.cashrequisitionretirement.repositories.security

import com.tabaapps.cashrequisitionretirement.models.security.Permission
import com.tabaapps.cashrequisitionretirement.models.security.Role
import com.tabaapps.cashrequisitionretirement.models.security.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermissionRepository : JpaRepository<Permission, Long> {
}