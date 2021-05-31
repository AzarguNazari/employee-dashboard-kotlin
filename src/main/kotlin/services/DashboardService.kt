package services

import dashboard.models.jpa.Employee
import exceptions.InvalidInput
import interfaces.serviceInterfaces.DashboardServiceInterface
import models.jpa.EmployeeDto
import models.jpa.Title
import org.springframework.stereotype.Service
import repositories.EmployeeRepository

@Service
class DashboardService(val employeeRepository: EmployeeRepository) : DashboardServiceInterface {

    @Throws(InvalidInput::class)
    override fun createAccount(employeeDto: EmployeeDto) {
        if (!employeeDto!!.password1.equals(employeeDto.password2, ignoreCase = true)) {
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