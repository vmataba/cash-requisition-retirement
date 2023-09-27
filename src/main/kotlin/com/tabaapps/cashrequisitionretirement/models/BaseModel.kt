package com.tabaapps.cashrequisitionretirement.models

import com.tabaapps.cashrequisitionretirement.models.security.User
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
open class BaseModel(

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var createdAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "created_by")
    var createdBy: User? = null

    var updatedAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "updated_by")
    var updatedBy: User? = null
}