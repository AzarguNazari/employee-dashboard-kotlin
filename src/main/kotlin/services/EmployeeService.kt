package services

import com.dashboard.repositories.EmployeeRepository
import interfaces.serviceInterfaces.CrudOperations
import interfaces.serviceInterfaces.EmployeeServiceInterface
import models.JPA.Employee
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService : CrudOperations<Employee>, EmployeeServiceInterface {
    @Autowired
    private val employeeRepository: EmployeeRepository? = null

    @Autowired
    private val taskRepository: TaskRepository? = null
    override fun deleteAllEmployees() {
        employeeRepository.deleteAll()
    }

    override fun addAllEmployees(users: List<Employee?>?) {
        employeeRepository.saveAll(users)
    }

    override fun save(employee: Employee) {
        if (employee.id != null) {
            val byId: Optional<Employee> = employeeRepository.findById(employee.id)
            if (byId.isPresent) throw BadRequestException()
        } else {
            employeeRepository.save(employee)
        }
    }

    override val all: List<T>
        get() = employeeRepository.findAll()

    override fun getById(id: Int): Employee {
        return employeeRepository.findById(id).orElseThrow { EmployeeNotFoundException() }
    }

    override fun getByUsername(username: String?): Optional<Employee?> {
        return employeeRepository.findByUsername(username)
    }

    override fun delete(employeeID: Int) {
        val employee: Optional<Employee> = employeeRepository.findById(employeeID)
        if (employee.isEmpty) throw EmployeeNotFoundException()
        employeeRepository.deleteById(employeeID)
    }

    override fun update(employeeId: Int, employee: Employee) {
        val emp: Optional<Employee> = employeeRepository.findById(employeeId)
        if (emp.isEmpty) throw EmployeeNotFoundException()
        employee.id = employeeId
        employeeRepository.deleteById(employeeId)
        employeeRepository.save(employee)
    }

    override fun assignTask(employeeId: Int?, taskID: Int?) {
        employeeRepository.findById(employeeId)
            .orElseThrow { EmployeeNotFoundException() }
            .getTasks()
            .add(taskRepository.findById(employeeId)
                .orElseThrow { TaskNotFoundException() }
            )
    }

    override fun unassignTask(employeeId: Int?, taskID: Int?) {
        employeeRepository.findById(employeeId)
            .orElseThrow { EmployeeNotFoundException() }
            .getTasks()
            .remove(taskRepository.findById(employeeId)
                .orElseThrow { TaskNotFoundException() }
            )
    }

    override fun exist(employeeId: Int): Boolean {
        return employeeRepository.findById(employeeId).isPresent()
    }

    override fun count(): Long {
        return employeeRepository.count()
    }
}