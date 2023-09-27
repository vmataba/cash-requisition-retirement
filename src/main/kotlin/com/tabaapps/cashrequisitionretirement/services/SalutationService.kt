package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.Salutation
import com.tabaapps.cashrequisitionretirement.repositories.SalutationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SalutationService {

    @Autowired
    lateinit var salutationRepository: SalutationRepository
    fun save(id: Long?, salutation: Salutation): Salutation {
        if (id == null) {
            salutation.createdAt = LocalDateTime.now()
            return salutationRepository.save(salutation)
        }
        salutation.updatedAt = LocalDateTime.now()
        return salutationRepository.save(salutation)
    }

    fun view(id: Long): Salutation {
        return salutationRepository.findById(id).orElseThrow { Exception("Salutation is not found") }
    }
}