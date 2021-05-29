package interfaces.controllerInterfaces;

import models.JPA.Task;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tasks")
public interface TaskControllerInterface {

    @PostMapping
    @ApiResponses(value = {@ApiResponse(description = "Successfully created new task",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createTask(@RequestBody Task task);

    @GetMapping
    @ApiResponses(value = {@ApiResponse(description = "Get all tasks",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllTasks();

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Get a specific task with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getTaskById(@PathVariable Integer id);

    @GetMapping("/status/{status}")
    @ApiResponses(value = {@ApiResponse(description = "Get tasks with specific status",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getTaskByStatus(@PathVariable String status);

    @DeleteMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Delete a task with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteTaskById(@PathVariable Integer id);

    @PutMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(description = "Update a task with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateTask(@PathVariable Integer employeeId, @RequestBody Task task);
}
