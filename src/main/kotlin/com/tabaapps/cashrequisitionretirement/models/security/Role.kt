package com.tabaapps.cashrequisitionretirement.models.security

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
data class Role(

    @Column(nullable = false, unique = true)
    @NotNull
    var code: String,

    @Column(unique = true, nullable = false)
    @NotNull
    var name: String,

    var isActive: Boolean,

    @OneToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_id")])
    var permissions: List<Permission>?,

    @OneToMany
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")])
    var users: List<User>?

) : BaseModel()
