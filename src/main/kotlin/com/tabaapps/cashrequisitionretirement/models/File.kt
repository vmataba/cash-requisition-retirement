package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
data class File(
    @NotNull
    @Column(nullable = false, unique = true)
    var name: String,

    @NotNull
    @Size(min = 4, max = 10)
    @Column(nullable = false, columnDefinition = "varchar(10)")
    var extension: String,

    @NotNull
    @Column(nullable = false)
    var ipAddress: String,

    @NotNull
    @Column(nullable = false)
    var browser: String,

    @ManyToOne(optional = false)
    var type: FileType

) : BaseModel() {
    enum class Code {
        PROFILE_PICTURE,
        RETIREMENT_ATTACHMENT
    }
}
