package com.tabaapps.cashrequisitionretirement.repositories.requisition

import com.tabaapps.cashrequisitionretirement.models.requisition.Requisition
import com.tabaapps.cashrequisitionretirement.models.requisition.RequisitionItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequisitionItemRepository : JpaRepository<RequisitionItem, Long> {
}