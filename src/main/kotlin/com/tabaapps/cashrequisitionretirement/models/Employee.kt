package com.tabaapps.cashrequisitionretirement.models

import com.tabaapps.cashrequisitionretirement.models.security.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

@Entity
data class Employee(

    @OneToOne(optional = false)
    var salutation: Salutation,

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
    @JoinColumn(name = "photo")
    var photo: File,

    @OneToOne
    var user: User?
) : BaseModel()
