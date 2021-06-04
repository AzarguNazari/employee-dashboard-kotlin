package dashboard.services

import dashboard.models.jpa.Employee
import dashboard.exceptions.InvalidInput
import dashboard.interfaces.serviceInterfaces.DashboardServiceInterface
import dashboard.models.dto.EmployeeDto
import dashboard.models.jpa.Title
import org.springframework.stereotype.Service
import dashboard.repositories.EmployeeRepository

@Service
class DashboardService(val employeeRepository: EmployeeRepository) : DashboardServiceInterface {

    @Throws(InvalidInput::class)
    override fun createAccount(employeeDto: EmployeeDto) {
        if (!employeeDto.password1.equals(employeeDto.password2, ignoreCase = true)) {
            throw InvalidInput("Passwords do not match")
        }
        val employee = Employee(
            username = employeeDto.username,
            firstname = employeeDto.firstName,
            lastname = employeeDto.lastName,
            password = employeeDto.password1,
            salary = employeeDto.salary,
            title = Title.valueOf(employeeDto.position)
        )
        employeeRepository.save(employee)
//        DashboardService.log.debug("New employee is saved {}", employee)
    }
}