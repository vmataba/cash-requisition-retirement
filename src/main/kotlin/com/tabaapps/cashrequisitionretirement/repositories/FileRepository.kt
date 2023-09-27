package com.tabaapps.cashrequisitionretirement.repositories

import com.tabaapps.cashrequisitionretirement.models.Action
import com.tabaapps.cashrequisitionretirement.models.File
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : JpaRepository<File, Long> {
}