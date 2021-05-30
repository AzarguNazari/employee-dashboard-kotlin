package services

import com.dashboard.repositories.EmployeeRepository
import exceptions.InvalidInput
import interfaces.serviceInterfaces.DashboardServiceInterface
import models.JPA.Employee
import org.springframework.stereotype.Service

@Service
@Slf4j
class DashboardService : DashboardServiceInterface {
    @Autowired
    private val employeeRepository: EmployeeRepository? = null
    @Throws(InvalidInput::class)
    override fun createAccount(employeeDto: EmployeeDto) {
        if (!employeeDto.password1.equals(employeeDto.password2, ignoreCase = true)) {
            throw InvalidInput("Passwords do not match")
        }
        val employee = Employee(
            employeeDto.username,
            employeeDto.firstName,
            employeeDto.lastName,
            employeeDto.password1,
            employeeDto.salary,
            Title.valueOf(employeeDto.position)
        )
        employeeRepository.save(employee)
        DashboardService.log.debug("New employee is saved {}", employee)
    }
}