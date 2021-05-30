package interfaces.controllerInterfaces

import dashboard.models.jpa.Task
import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Tasks")
interface TaskControllerInterface {
    @PostMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created new task",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createTask(@RequestBody task: Task?): ResponseEntity<*>?

    @get:ApiResponses(
        value = [ApiResponse(
            description = "Get all tasks",
            responseCode = "200",
            content = arrayOf(
                Content(
                    schema = Schema(implementation = ResponseEntity::class)
                )
            )
        )]
    )
    @get:GetMapping
    val allTasks: ResponseEntity<*>?

    @GetMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get a specific task with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getTaskById(@PathVariable id: Int?): ResponseEntity<*>?

    @GetMapping("/status/{status}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get tasks with specific status",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getTaskByStatus(@PathVariable status: String?): ResponseEntity<*>?

    @DeleteMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete a task with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteTaskById(@PathVariable id: Int?): ResponseEntity<*>?

    @PutMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update a task with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateTask(@PathVariable employeeId: Int?, @RequestBody task: Task?): ResponseEntity<*>?
}