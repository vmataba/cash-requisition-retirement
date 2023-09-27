package com.tabaapps.cashrequisitionretirement.repositories.retirement

import com.tabaapps.cashrequisitionretirement.models.retirement.RetirementComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RetirementCommentRepository : JpaRepository<RetirementComment, Long> {
}