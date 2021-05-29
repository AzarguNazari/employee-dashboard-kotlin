package com.dashboard.interfaces.controllerInterfaces;

import com.dashboard.models.JPA.Employee;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employees")
public interface EmployeeControllerInterface {

    @PostMapping
    @ApiResponses(value = {@ApiResponse(description = "Successfully created new employee",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createEmployee(@RequestBody Employee employee);

    @GetMapping
    @ApiResponses(value = {@ApiResponse(description = "Get all employees",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllEmployees(Pageable pageable);

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Get a specific employee with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getEmployeeById(@PathVariable Integer id);

    @DeleteMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Delete a employee with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id);

    @PutMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Update an employee with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee);

    // Task Operation with Employee
    @PostMapping("/{employeeID}/tasks/{taskID}")
    @ApiResponses(value = {@ApiResponse(description = "Update a employees with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> assignTask(@PathVariable Integer employeeID, @PathVariable Integer taskID);

    @DeleteMapping("/{employeeID}/tasks/{taskID}")
    @ApiResponses(value = {@ApiResponse(description = "Update a employees with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> unassignTask(@PathVariable Integer employeeID, @PathVariable Integer taskID);
}
