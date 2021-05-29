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
import dashboard.models.jpa.Announcement
import dashboard.exceptions.AnnouncementNotFoundException
import lombok.extern.slf4j.Slf4j
import dashboard.models.jpa.Attendance
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
import dashboard.models.jpa.EmployeeDto
import dashboard.models.jpa.Employee
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
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService : CrudOperations<Employee?>, EmployeeServiceInterface {
    @Autowired
    private val employeeRepository: EmployeeRepository? = null

    @Autowired
    private val taskRepository: TaskRepository? = null
    override fun deleteAllEmployees() {
        employeeRepository!!.deleteAll()
    }

    override fun addAllEmployees(users: List<Employee?>?) {
        employeeRepository!!.saveAll(users)
    }

    override fun save(employee: Employee) {
        if (employee.id != null) {
            val byId = employeeRepository!!.findById(employee.id!!)
            if (byId.isPresent) throw BadRequestException()
        } else {
            employeeRepository!!.save(employee)
        }
    }

    val all: List<Employee>
        get() = employeeRepository!!.findAll()

    override fun getById(id: Int): Employee {
        return employeeRepository!!.findById(id).orElseThrow { EmployeeNotFoundException() }
    }

    override fun getByUsername(username: String?): Optional<Employee?>? {
        return employeeRepository!!.findByUsername(username)
    }

    override fun delete(employeeID: Int) {
        val employee = employeeRepository!!.findById(employeeID)
        if (employee.isEmpty) throw EmployeeNotFoundException()
        employeeRepository.deleteById(employeeID)
    }

    override fun update(employeeId: Int, employee: Employee) {
        val emp = employeeRepository!!.findById(employeeId)
        if (emp.isEmpty) throw EmployeeNotFoundException()
        employee.id = employeeId
        employeeRepository.deleteById(employeeId)
        employeeRepository.save(employee)
    }

    override fun assignTask(employeeId: Int?, taskID: Int?) {
        employeeRepository!!.findById(employeeId!!)
            .orElseThrow { EmployeeNotFoundException() }
            .tasks
            .add(
                taskRepository!!.findById(employeeId)
                    .orElseThrow { TaskNotFoundException() }
            )
    }

    override fun unassignTask(employeeId: Int?, taskID: Int?) {
        employeeRepository!!.findById(employeeId!!)
            .orElseThrow { EmployeeNotFoundException() }
            .tasks
            .remove(
                taskRepository!!.findById(employeeId)
                    .orElseThrow { TaskNotFoundException() }
            )
    }

    override fun exist(employeeId: Int): Boolean {
        return employeeRepository!!.findById(employeeId).isPresent
    }

    override fun count(): Long {
        return employeeRepository!!.count()
    }
}