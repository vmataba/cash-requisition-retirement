package com.tabaapps.cashrequisitionretirement.models.retirement

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull

@Entity
data class RetirementComment(
    @NotNull
    @Column(nullable = false)
    var comment: String,

    @ManyToOne(optional = false)
    var retirement: Retirement
) : BaseModel()
