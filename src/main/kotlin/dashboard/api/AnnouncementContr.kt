package dashboard.api

import dashboard.api.interfaces.EmployeeControllerInterface
import dashboard.exception.ApiError
import dashboard.exception.EmployeeNotFoundException
import dashboard.models.Employee
import dashboard.services.EmployeeService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/announcements")
@Tag(name = "Announcements")
class AnnouncementsController(val employeeService: EmployeeService) : EmployeeControllerInterface {

    val logger: Logger = LoggerFactory.getLogger(AnnouncementsController::class.java)

    override fun createEmployee(employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.save(employee)
            logger.debug("New employee {} is added", employee)
            ResponseEntity("New employee is created", HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getAllEmployees() = ResponseEntity<Any?>(employeeService.all, HttpStatus.OK)

    override fun getEmployeeById(id: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(employeeService.getById(id), HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            logger.debug("employee {} is already existed", id)
            ResponseEntity<Any>(ApiError("employee with id $id doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteEmployeeById(id: Int): ResponseEntity<*> {
        return try {
            employeeService.delete(id)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            logger.debug("employee {} is already existed", id)
            ResponseEntity<Any>(ApiError("employee with id $id doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateEmployee(employeeId: Int, employee: Employee): ResponseEntity<*> {
        return try {
            employeeService.update(employeeId, employee)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            logger.debug("employee {} is already existed", employeeId)
            ResponseEntity<Any>(ApiError("attendance with id $employeeId doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun assignTask(employeeID: Int, taskID: Int): ResponseEntity<*> {
        TODO("Not yet implemented")
    }

    override fun unassignTask(employeeID: Int, taskID: Int): ResponseEntity<*> {
        TODO("Not yet implemented")
    }
}