package com.tabaapps.cashrequisitionretirement.repositories

import com.tabaapps.cashrequisitionretirement.models.Action
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActionRepository : JpaRepository<Action, Long> {
}