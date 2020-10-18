package dashboard.controller.interfaces

import dashboard.model.Employee
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface EmployeeControllerInterface {
    
    @PostMapping
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<*>

    @GetMapping
    fun getAllEmployees(): ResponseEntity<*>

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Int): ResponseEntity<*>

    @DeleteMapping("/{id}")
    fun deleteEmployeeById(@PathVariable id: Int): ResponseEntity<*>

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable employeeId: Int, @RequestBody employee: Employee): ResponseEntity<*>

    // Task Operation with Employee
    @PostMapping("/{employeeID}/tasks/{taskID}")
    fun assignTask(@PathVariable employeeID: Int, @PathVariable taskID: Int): ResponseEntity<*>

    @DeleteMapping("/{employeeID}/tasks/{taskID}")
    fun unassignTask(@PathVariable employeeID: Int, @PathVariable taskID: Int): ResponseEntity<*>
}