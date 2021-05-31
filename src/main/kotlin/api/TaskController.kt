package api

import dashboard.models.jpa.Task
import exceptions.ApiError
import exceptions.EmployeeNotFoundException
import interfaces.controllerInterfaces.TaskControllerInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import services.TaskService

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(val taskService: TaskService) : TaskControllerInterface {
    
    override fun createTask(task: Task): ResponseEntity<*> {
        return try {
            taskService.save(task)
//            TaskController.log.debug("New task {} is added", task)
            ResponseEntity<String>("New task is created", HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun allTasks(): ResponseEntity<*> {
        return try {
            ResponseEntity<Any>(taskService.all(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun getTaskById(id: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any>(taskService.getById(id), HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
//            TaskController.log.debug("account {} is already existed", id)
            ResponseEntity<Any>(
                ApiError("account with id $id is doesn't exist", HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
            )
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getTaskByStatus(status: String): ResponseEntity<*> {
        return try {
            ResponseEntity<Any>(taskService.findTaskByStatus(status), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun deleteTaskById(id: Int): ResponseEntity<*> {
        return try {
            taskService.delete(id)
            ResponseEntity<String>("Task with id $id is deleted", HttpStatus.NO_CONTENT)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun updateTask(taskID: Int, task: Task): ResponseEntity<*> {
        return try {
            taskService.update(taskID, task)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}