package repositories

import dashboard.models.jpa.Employee
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmployeeRepository : JpaRepository<Employee, Int> {
    fun findByUsername(username: String): Optional<Employee>
}