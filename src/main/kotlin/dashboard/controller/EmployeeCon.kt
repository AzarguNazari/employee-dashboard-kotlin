package dashboard.controller


import dashboard.controller.interfaces.EmployeeControllerInterface
import dashboard.exception.*
import dashboard.model.Employee
import dashboard.service.EmployeeService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employees")
class EmployeeController(val employeeService: EmployeeService) : EmployeeControllerInterface {

    val logger: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    override fun createEmployee(employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.save(employee)
            logger.debug("New employee {} is created", employee)
            ResponseEntity("New employee created", HttpStatus.CREATED)
        } catch (ex: BadRequestException) {
            ResponseEntity<Any>(ApiError("Employee with id ${employee.id} is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    override fun getAllEmployees() = ResponseEntity<Any?>(employeeService.getAll(), HttpStatus.OK)

    override fun getEmployeeById(id: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(employeeService.getById(id), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteEmployeeById(id: Int): ResponseEntity<*> {
        return try {
            employeeService.delete(id)
            logger.debug("Employee with id $id is deleted")
            ResponseEntity("Employee with id $id is deleted", HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(id)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateEmployee(employeeId: Int, employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.update(employeeId, employee)
            logger.debug("Employee $employee is updated")
            ResponseEntity("Employee with id $employeeId is updated", HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeId)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun assignTask(employeeID: Int, taskID: Int): ResponseEntity<*> {
        return try {
//            employeeService.assignTask(employeeID, taskID)
            logger.debug("Task {} is assigned to {}", taskID, employeeID)
            ResponseEntity("Task with ID $taskID is assigned to Employee with ID $employeeID", HttpStatus.OK)
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
//            employeeService.unassignTask(employeeID, taskID)
            logger.debug("Task {} is unassigned from to employee {}", taskID, employeeID)
            ResponseEntity("Task with ID $taskID is assigned to Employee with ID $employeeID", HttpStatus.OK)
        } catch (ex: TaskNotFoundException) {
            ExceptionFactory.TASK_NOT_FOUND(taskID)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID)
        } catch (ex: Exception) {
            ExceptionFactory.INTERNAL_EXCEPTION()
        }
    }

}