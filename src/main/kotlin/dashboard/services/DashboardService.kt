package dashboard.services

import dashboard.models.jpa.EmployeeDto.password1
import dashboard.models.jpa.EmployeeDto.password2
import dashboard.models.jpa.EmployeeDto.username
import dashboard.models.jpa.EmployeeDto.firstName
import dashboard.models.jpa.EmployeeDto.lastName
import dashboard.models.jpa.EmployeeDto.salary
import dashboard.models.jpa.EmployeeDto.position
import dashboard.models.jpa.Employee.id
import dashboard.models.jpa.Employee.tasks
import dashboard.repositories.AnnouncementRepository
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.exceptions.AnnouncementNotFoundException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import dashboard.repositories.AttendanceRepository
import dashboard.services.AttendanceService
import dashboard.exceptions.AttendanceNotFoundException
import lombok.extern.log4j.Log4j2
import dashboard.interfaces.serviceInterfaces.ChatServiceInterface
import dashboard.interfaces.serviceInterfaces.DashboardServiceInterface
import dashboard.repositories.EmployeeRepository
import kotlin.Throws
import dashboard.exceptions.InvalidInput
import dashboard.services.DashboardService
import dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface
import dashboard.repositories.TaskRepository
import dashboard.exceptions.BadRequestException
import dashboard.exceptions.EmployeeNotFoundException
import dashboard.exceptions.TaskNotFoundException
import dashboard.interfaces.serviceInterfaces.TaskServiceInterface
import dashboard.interfaces.serviceInterfaces.UserServiceInterface
import dashboard.repositories.UserRepository
import dashboard.exceptions.UserNotFoundException
import dashboard.models.jpa.*
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