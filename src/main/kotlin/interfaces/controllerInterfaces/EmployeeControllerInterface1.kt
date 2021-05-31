package interfaces.controllerInterfaces

import dashboard.models.jpa.Employee
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Employees")
interface EmployeeControllerInterface {
    @PostMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created new employee",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<*>

    @GetMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Get all employees",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getAllEmployees(pageable: Pageable): ResponseEntity<*>

    @GetMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get a specific employee with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getEmployeeById(@PathVariable id: Int): ResponseEntity<*>

    @DeleteMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete a employee with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteEmployeeById(@PathVariable id: Int): ResponseEntity<*>

    @PutMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update an employee with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateEmployee(@PathVariable employeeId: Int, @RequestBody employee: Employee): ResponseEntity<*>

    // Task Operation with Employee
    @PostMapping("/{employeeID}/tasks/{taskID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update a employees with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun assignTask(@PathVariable employeeID: Int, @PathVariable taskID: Int): ResponseEntity<*>

    @DeleteMapping("/{employeeID}/tasks/{taskID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update a employees with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun unassignTask(@PathVariable employeeID: Int, @PathVariable taskID: Int): ResponseEntity<*>
}