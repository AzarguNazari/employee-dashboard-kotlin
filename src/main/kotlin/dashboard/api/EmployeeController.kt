package dashboard.api

import dashboard.exceptions.*
import dashboard.models.jpa.Employee
import dashboard.interfaces.controllerInterfaces.EmployeeControllerInterface
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import dashboard.services.EmployeeService

@RestController
@RequestMapping("/dashboard/api/v1/employees")
class EmployeeController(val employeeService: EmployeeService) : EmployeeControllerInterface {

    private val LOGGER: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    override fun createEmployee(employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.save(employee)
            LOGGER.debug("employee {} is created", employee)
            ResponseEntity<String>("employee created", HttpStatus.CREATED)
        } catch (ex: BadRequestException) {
            ResponseEntity(ApiError("Employee with id ${employee.id} is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST)
        } catch (ex: Exception) {
            ResponseEntity(ApiError ("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getAllEmployees(pageable: Pageable): ResponseEntity<*> {
        return return try {
            ResponseEntity<List<Employee>>(employeeService.all(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getEmployeeById(employeeID: Int): ResponseEntity<*> {
        return return try {
            ResponseEntity<Employee>(employeeService.getById(employeeID), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteEmployeeById(employeeID: Int): ResponseEntity<*> {
        return try {
            employeeService.delete(employeeID)
            LOGGER.debug("Employee with id {} is deleted", employeeID)
            ResponseEntity<String>("Employee with id $employeeID is deleted", HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID)
        } catch (ex: Exception) {
            ResponseEntity(ApiError ("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateEmployee(employeeId: Int, employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.update(employeeId, employee)
            LOGGER.debug("Employee {} is updated", employee)
            ResponseEntity<String>("Employee with id  $employeeId is updated", HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeId)
        } catch (ex: Exception) {
            ResponseEntity(ApiError ("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun assignTask(employeeID: Int, taskID: Int): ResponseEntity<*> {
        return try {
            employeeService.assignTask(employeeID, taskID)
            LOGGER.debug("Task {} is assigned to {}", taskID, employeeID)
            ResponseEntity<String>("Task with ID $taskID is assigned to Employee with ID $employeeID", HttpStatus.OK)
        } catch (ex: TaskNotFoundException) {
            ExceptionFactory.TASK_NOT_FOUND(taskID)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID)
        } catch (ex: Exception) {
            ExceptionFactory.INTERNAL_EXCEPTION()
        }
    }

    override fun unassignTask(employeeID: Int, taskID: Int): ResponseEntity<*> {
        return try {
            employeeService.unassignTask(employeeID, taskID)
            LOGGER.debug("Task {} is unassigned from to employee {}", taskID, employeeID)
            ResponseEntity<String>("Task with ID $taskID is assigned to Employee with ID $employeeID", HttpStatus.OK)
        } catch (ex: TaskNotFoundException) {
            ExceptionFactory.TASK_NOT_FOUND(taskID)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID)
        } catch (ex: Exception) {
            ExceptionFactory.INTERNAL_EXCEPTION()
        }
    }
}
