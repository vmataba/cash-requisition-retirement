package com.tabaapps.cashrequisitionretirement.models.requisition

import com.tabaapps.cashrequisitionretirement.models.BaseModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull

@Entity
data class RequisitionState(
    @Column(nullable = false, unique = true) @NotNull var type: Type,

    @Column(nullable = false, unique = true, columnDefinition = "varchar(64)") @NotNull var name: String,

    var description: String,

    var isActive: Boolean

) : BaseModel() {
    enum class Type {
        INITIATED, IN_PROGRESS, REJECTED, APPROVED, OFFERED, RETIRED
    }
}
