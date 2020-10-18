package dashboard.controller


import dashboard.controller.interfaces.TaskControllerInterface
import dashboard.exception.ApiError
import dashboard.exception.EmployeeNotFoundException
import dashboard.model.Task
import dashboard.service.TaskService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Tasks")
class TaskController(val taskService: TaskService) : TaskControllerInterface {

    val logger: Logger = LoggerFactory.getLogger(TaskController::class.java)

    override fun createTask(task: Task): ResponseEntity<*> {
        return try {
            taskService.save(task)
            logger.debug("New task $task is added")
            ResponseEntity("New task is created", HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun allTasks(): ResponseEntity<*> = ResponseEntity<Any?>(taskService.getAll(), HttpStatus.OK)

    override fun getTaskById(id: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(taskService.getById(id), HttpStatus.OK)
        } catch (ex: EmployeeNotFoundException) {
            logger.debug("account {} is already existed", id)
            ResponseEntity<Any>(ApiError("account with id $id is doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getTaskByStatus(status: String): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(taskService.findTaskByStatus(status), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteTaskById(id: Int): ResponseEntity<*> {
        return try {
            taskService.delete(id)
            ResponseEntity("Task with id $id is deleted", HttpStatus.NO_CONTENT)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateTask(taskId: Int, task: Task): ResponseEntity<*> {
        return try {
            taskService.update(taskId, task)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
