package com.tabaapps.cashrequisitionretirement.repositories

import com.tabaapps.cashrequisitionretirement.models.FileType
import com.tabaapps.cashrequisitionretirement.models.Title
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TitleRepository : JpaRepository<Title, Long> {
}