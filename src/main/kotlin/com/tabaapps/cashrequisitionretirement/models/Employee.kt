package com.tabaapps.cashrequisitionretirement.models

import com.tabaapps.cashrequisitionretirement.models.security.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

@Entity
data class Employee(
    @Column(nullable = false)
    var firstName: String,

    var middleName: String?,

    @Column(nullable = false)
    var lastName: String,

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(unique = true, nullable = false)
    var phone: String,

    @ManyToOne(optional = false)
    var title: Title,

    @OneToOne
    var user: User?
) : BaseModel()
