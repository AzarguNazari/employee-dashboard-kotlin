package dashboard.services.interfaces

import dashboard.models.Employee
import java.util.*

interface EmployeeServiceInterface {
    fun deleteAllEmployees()
    fun addAllEmployees(users: List<Employee>)
    fun addNewEmployee(employee: Employee)
    fun getEmployeeById(id: Int): Optional<Employee>
    fun getAllEmployees(): List<Employee>
    fun totalEmployees(): Long
    fun getByUsername(username: String): Optional<Employee>
    fun deleteEmployeeById(id: Int)
    fun updateEmployee(employeeId: Int, employee: Employee)
    fun assignTask(employeeId: Int, taskID: Int)
    fun unassignTask(employeeId: Int, taskID: Int)
}
