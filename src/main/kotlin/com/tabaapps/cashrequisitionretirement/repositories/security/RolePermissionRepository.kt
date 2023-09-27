package com.tabaapps.cashrequisitionretirement.repositories.security

import com.tabaapps.cashrequisitionretirement.models.security.RolePermission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolePermissionRepository : JpaRepository<RolePermission, Long> {
}