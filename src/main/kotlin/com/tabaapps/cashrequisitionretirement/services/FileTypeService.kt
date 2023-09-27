package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.FileType
import com.tabaapps.cashrequisitionretirement.repositories.FileTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FileTypeService {

    @Autowired
    lateinit var fileTypeRepository: FileTypeRepository

    fun save(id: Long?, fileType: FileType): FileType {
        if (id == null) {
            fileType.createdAt = LocalDateTime.now()
            return fileTypeRepository.save(fileType)
        }
        fileType.updatedAt = LocalDateTime.now()
        return fileTypeRepository.save(fileType)
    }

    fun view(id: Long): FileType {
        return fileTypeRepository.findById(id).orElseThrow { Exception("File type is not found") }
    }
}