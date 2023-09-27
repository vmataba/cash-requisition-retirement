package com.tabaapps.cashrequisitionretirement.models.requisition

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
data class RequisitionItem(
    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var requestedAmount: Double,

    var approvedAmount: Double,

    @ManyToOne(optional = false)
    var requisition: Requisition
) : BaseModel()
