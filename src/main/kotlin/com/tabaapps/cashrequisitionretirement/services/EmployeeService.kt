package com.tabaapps.cashrequisitionretirement.services

import com.tabaapps.cashrequisitionretirement.models.Employee
import com.tabaapps.cashrequisitionretirement.models.security.User
import com.tabaapps.cashrequisitionretirement.repositories.EmployeeRepository
import com.tabaapps.cashrequisitionretirement.repositories.security.UserRepository
import com.tabaapps.cashrequisitionretirement.security.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmployeeService {

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var securityConfig: Configuration

    fun save(id: Long?, employee: Employee): Employee {
        if (id == null) {
            employee.createdAt = LocalDateTime.now()
            return employeeRepository.save(employee)
        }
        employee.updatedAt = LocalDateTime.now()
        return employeeRepository.save(employee)
    }

    fun view(id: Long): Employee {
        return this.employeeRepository.findById(id).orElseThrow { Exception("Employee is not found") }
    }

    fun createUserAccount(id: Long): User {
        val employee = employeeRepository.findById(id).orElseThrow { Exception("Employee is not found") }
        val user = User(
            employee = employee,
            username = employee.email,
            password = securityConfig.loadPasswordEncoder().encode(employee.lastName.uppercase()),
            isActive = false,
            roles = null
        )
        user.createdAt = LocalDateTime.now()
        return userRepository.save(user)
    }
}