package com.dashboard.interfaces.controllerInterfaces;

import com.dashboard.models.JPA.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users")
public interface UserControllerInterface {

    @PostMapping
    @Operation(summary = "create a new user")
    @ApiResponses(value = {@ApiResponse(description = "Successfully created new user",
                                        responseCode = "201",
                                        content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createUser(@RequestBody User user);

    @GetMapping
    @Operation(summary = "get list of users")
    @ApiResponses(value = {@ApiResponse(description = "Get all the users",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllUsers();

    @GetMapping("/{userID}")
    @Operation(summary = "get a specific user")
    @ApiResponses(value = {@ApiResponse(description = "Get a user by ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getUserById(@PathVariable Integer userID);

    @DeleteMapping("/{userID}")
    @Operation(summary = "delete a specific user")
    @ApiResponses(value = {@ApiResponse(description = "Delete a user by ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteUserById(@PathVariable Integer userID);

    @PutMapping("/{userID}")
    @Operation(summary = "update a specific user")
    @ApiResponses(value = {@ApiResponse(description = "Update a user by ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateUser(@PathVariable Integer userID, @RequestBody User user);
}
