package com.tabaapps.cashrequisitionretirement.models.security

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity(name = "role_permission")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["role_id","permission_id"])])
data class RolePermission(
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    var role: Role,

    @ManyToOne(optional = false)
    @JoinColumn(name = "permission_id")
    var permission: Permission,

    var isActive: Boolean
):BaseModel()
