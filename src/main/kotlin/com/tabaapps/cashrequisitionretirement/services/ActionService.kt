package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.Action
import com.tabaapps.cashrequisitionretirement.repositories.ActionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ActionService {

    @Autowired
    lateinit var actionRepository: ActionRepository

    fun save(id: Long?, action: Action): Action {
        if (id == null) {
            action.createdAt = LocalDateTime.now()
            return actionRepository.save(action)
        }
        action.updatedAt = LocalDateTime.now()
        return actionRepository.save(action)
    }

    fun view(id: Long): Action {
        return actionRepository.findById(id).orElseThrow { Exception("Action is not found") }
    }
}