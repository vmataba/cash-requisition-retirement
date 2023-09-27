package com.tabaapps.cashrequisitionretirement.models.retirement

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import com.tabaapps.cashrequisitionretirement.models.File
import com.tabaapps.cashrequisitionretirement.models.requisition.Requisition
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
data class Retirement(
    @NotNull
    @Column(nullable = false, columnDefinition = "double(22,2)")
    var amount: Double,

    @NotNull
    @Column(nullable = false)
    var description: String,

    @NotNull
    @OneToOne
    @JoinColumn(name = "receipt")
    var receipt: File,

    @NotNull
    @Column(nullable = false)
    var state: State,

    @ManyToOne(optional = false)
    var requisition: Requisition,

    @OneToMany(mappedBy = "retirement")
    var comments: List<RetirementComment>?

) : BaseModel() {

    enum class State {
        PENDING,
        OK,
        NOT_OK
    }

}
