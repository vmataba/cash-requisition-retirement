package com.tabaapps.cashrequisitionretirement.repositories.retirement

import com.tabaapps.cashrequisitionretirement.models.retirement.Retirement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RetirementRepository : JpaRepository<Retirement, Long> {
}