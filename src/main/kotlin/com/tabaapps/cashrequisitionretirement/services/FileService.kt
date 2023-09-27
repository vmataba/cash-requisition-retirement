package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.File
import com.tabaapps.cashrequisitionretirement.repositories.FileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FileService {

    @Autowired
    lateinit var fileRepository: FileRepository

    fun save(id: Long?, file: File): File {
        if (id == null) {
            file.createdAt = LocalDateTime.now()
            return fileRepository.save(file)
        }
        file.updatedAt = LocalDateTime.now()
        return fileRepository.save(file)
    }

    fun view(id: Long): File {
        return fileRepository.findById(id).orElseThrow { Exception("File is not found") }
    }
}