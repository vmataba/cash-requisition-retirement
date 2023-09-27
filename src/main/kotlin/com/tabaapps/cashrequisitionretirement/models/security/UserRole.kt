package com.tabaapps.cashrequisitionretirement.models.security

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity(name = "user_role")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["user_id","role_id"])])
data class UserRole(
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    var user: User,

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    var role: Role,

    var isActive: Boolean
):BaseModel()
