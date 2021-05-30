package dashboard.services

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import dashboard.repositories.EmployeeRepository
import kotlin.Throws
import dashboard.exceptions.InvalidInput
import dashboard.models.jpa.*
import models.jpa.EmployeeDto
import models.jpa.Title
import org.springframework.stereotype.Service

@Service
@Slf4j
class DashboardService : DashboardServiceInterface {
    @Autowired
    private val employeeRepository: EmployeeRepository? = null
    @Throws(InvalidInput::class)
    override fun createAccount(employeeDto: EmployeeDto?) {
        if (!employeeDto!!.password1.equals(employeeDto.password2, ignoreCase = true)) {
            throw InvalidInput("Passwords do not match")
        }
        val employee = Employee(
            employeeDto.username,
            employeeDto.firstName,
            employeeDto.lastName,
            employeeDto.password1,
            employeeDto.salary,
            Title.valueOf(
                employeeDto.position
            )
        )
        employeeRepository!!.save(employee)
        DashboardService.log.debug("New employee is saved {}", employee)
    }
}