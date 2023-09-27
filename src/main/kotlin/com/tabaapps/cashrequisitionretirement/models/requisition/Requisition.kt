package com.tabaapps.cashrequisitionretirement.models.requisition

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import com.tabaapps.cashrequisitionretirement.models.Employee
import com.tabaapps.cashrequisitionretirement.models.retirement.Retirement
import com.tabaapps.cashrequisitionretirement.models.security.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
data class Requisition(
    @Column(nullable = false, columnDefinition = "double(22,2)")
    var requestedAmount: Double,

    @Column(nullable = false, columnDefinition = "double(22,2)")
    var approvedAmount: Double,

    @ManyToOne(optional = false)
    var state: RequisitionState,

    var offered: Boolean,

    @ManyToOne
    var offeredBy: User,

    var offeredAt: LocalDateTime,

    @ManyToOne(optional = false)
    var employee: Employee,

    @OneToMany(mappedBy = "requisition")
    var items: List<RequisitionItem>?,

    @OneToMany(mappedBy = "requisition")
    var conversations: List<RequisitionConversation>?,

    @OneToMany(mappedBy = "requisition")
    var retirements: List<Retirement>?

) : BaseModel()