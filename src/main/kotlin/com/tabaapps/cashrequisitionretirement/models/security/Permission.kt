package com.tabaapps.cashrequisitionretirement.models.security

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
data class Permission(
    @Column(unique = true, nullable = false)
    @NotNull
    @Size(min = 5, max = 128)
    var pattern: String,

    @Column(unique = true, nullable = false)
    @NotNull
    var name: String,

    var isActive: Boolean,

    @OneToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = [JoinColumn(name = "permission_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: List<Role>?,
) : BaseModel()
