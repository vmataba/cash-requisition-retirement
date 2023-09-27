package com.tabaapps.cashrequisitionretirement.repositories

import com.tabaapps.cashrequisitionretirement.models.Action
import com.tabaapps.cashrequisitionretirement.models.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
}