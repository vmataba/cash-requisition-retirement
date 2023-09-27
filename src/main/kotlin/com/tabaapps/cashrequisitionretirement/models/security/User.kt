package com.tabaapps.cashrequisitionretirement.models.security

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import com.tabaapps.cashrequisitionretirement.models.Employee
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull

@Entity
data class User(

    @Column(nullable = false, unique = true)
    @NotNull
    var username: String,

    @Column(nullable = false)
    @NotNull
    var password: String,

    var isActive: Boolean,

    @OneToOne(optional = false)
    var employee: Employee,

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: List<Role>?
) : BaseModel()
