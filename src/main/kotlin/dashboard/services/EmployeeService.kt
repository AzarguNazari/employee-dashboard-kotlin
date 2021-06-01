package dashboard.services

import dashboard.models.jpa.Employee
import dashboard.exceptions.BadRequestException
import dashboard.exceptions.EmployeeNotFoundException
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface
import org.springframework.stereotype.Service
import dashboard.repositories.EmployeeRepository
import dashboard.repositories.TaskRepository
import java.util.*

@Service
class EmployeeService(val employeeRepository: EmployeeRepository,
                      val taskRepository: TaskRepository
) : CrudOperations<Employee>, EmployeeServiceInterface {

    override fun deleteAllEmployees() {
        employeeRepository.deleteAll()
    }

    override fun addAllEmployees(users: List<Employee>) {
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

    override fun all(): List<Employee> = employeeRepository.findAll()

    override fun getById(id: Int): Employee {
        return employeeRepository.findById(id).orElseThrow { EmployeeNotFoundException() }
    }

    override fun getByUsername(username: String): Optional<Employee> {
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

    override fun assignTask(employeeId: Int, taskID: Int) {
//        employeeRepository.findById(employeeId).orElseThrow { EmployeeNotFoundException() }

    }

    override fun unassignTask(employeeId: Int, taskID: Int) {
//        employeeRepository.findById(employeeId)
//            .orElseThrow { EmployeeNotFoundException() }
//
    }

    override fun exist(employeeId: Int): Boolean {
        return employeeRepository.findById(employeeId).isPresent()
    }

    override fun count(): Long {
        return employeeRepository.count()
    }
}