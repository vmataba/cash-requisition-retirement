package com.tabaapps.cashrequisitionretirement.models.requisition

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import com.tabaapps.cashrequisitionretirement.models.TitleAction
import com.tabaapps.cashrequisitionretirement.models.security.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Size

@Entity
data class RequisitionConversation(
    @Size(min = 5, max = 255)
    @Column(nullable = false)
    var words: String,

    @ManyToOne(optional = false)
    var requisition: Requisition,

    @ManyToOne(optional = false)
    var titleAction: TitleAction,

    @ManyToOne(optional = false)
    var user: User,
) : BaseModel()
