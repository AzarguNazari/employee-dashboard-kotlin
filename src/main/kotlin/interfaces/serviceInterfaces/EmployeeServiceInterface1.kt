package interfaces.serviceInterfaces

import dashboard.models.jpa.Employee
import java.util.*

interface EmployeeServiceInterface {
    fun deleteAllEmployees()
    fun addAllEmployees(users: List<Employee>)
    fun getByUsername(username: String): Optional<Employee>
    fun assignTask(employeeId: Int, taskID: Int)
    fun unassignTask(employeeId: Int, taskID: Int)
    fun count(): Long
}