package api

import dashboard.models.jpa.Employee
import exceptions.*
import interfaces.controllerInterfaces.EmployeeControllerInterface
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import services.EmployeeService

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(val employeeService: EmployeeService) : EmployeeControllerInterface {


    override fun createEmployee(employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.save(employee)
    //            log.debug("employee {} is created", employee)
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

    override fun getEmployeeById(id: Int): ResponseEntity<*> {
        return return try {
            ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteEmployeeById(id: Int): ResponseEntity<*> {
        return try {
            employeeService.delete(id)
//            log.debug("Employee with id {} is deleted", employeeID)
            ResponseEntity<String>("Employee with id $id is deleted", HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            ExceptionFactory.EMPLOYEE_NOT_FOUND(id)
        } catch (ex: Exception) {
            ResponseEntity(ApiError ("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateEmployee(employeeId: Int, employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.update(employeeId, employee)
//            log.debug("Employee {} is updated", employee)
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
    //            log.debug("Task {} is assigned to {}", taskID, employeeID)
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
//            log.debug("Task {} is unassigned from to employee {}", taskID, employeeID)
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
