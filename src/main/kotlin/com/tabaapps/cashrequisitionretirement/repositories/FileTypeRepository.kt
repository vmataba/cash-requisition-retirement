package com.tabaapps.cashrequisitionretirement.repositories

import com.tabaapps.cashrequisitionretirement.models.FileType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileTypeRepository : JpaRepository<FileType, Long> {
}