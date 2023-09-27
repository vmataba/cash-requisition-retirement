package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotNull
import java.nio.file.Files

@Entity
data class FileType(

    @NotNull
    @Column(nullable = false, unique = true)
    var code: Code,

    @NotNull
    @Column(nullable = false, unique = true)
    var name: String,

    var description: String,

    @NotNull
    @Column(nullable = false, unique = true)
    var path: String,

    @NotNull
    @Column(nullable = false)
    var allowedExtensions: List<String>,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    var files: List<File>?
) : BaseModel() {
    enum class Code {
        PROFILE_PICTURE,
        RETIREMENT_ATTACHMENT
    }
}
