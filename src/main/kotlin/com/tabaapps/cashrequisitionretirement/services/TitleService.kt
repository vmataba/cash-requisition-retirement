package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.Action
import com.tabaapps.cashrequisitionretirement.models.Title
import com.tabaapps.cashrequisitionretirement.repositories.TitleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TitleService {

    @Autowired
    lateinit var titleRepository: TitleRepository

    fun save(id: Long?, title: Title, actions: List<Action>?): Title {
        title.actions!!.plus(actions)
        if (id == null) {
            title.createdAt = LocalDateTime.now()
            return titleRepository.save(title)
        }
        title.updatedAt = LocalDateTime.now()
        return titleRepository.save(title)
    }

    fun view(id: Long): Title {
        return titleRepository.findById(id).orElseThrow { Exception("Title is not found") }
    }
}