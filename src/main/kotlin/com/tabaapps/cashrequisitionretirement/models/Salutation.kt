package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull

@Entity
data class Salutation(
    @Column(nullable = false, unique = true)
    @NotNull
    var acronym: String,

    @Column(nullable = false, unique = true)
    @NotNull
    var name: String,

    var isActive: Boolean

) : BaseModel()
