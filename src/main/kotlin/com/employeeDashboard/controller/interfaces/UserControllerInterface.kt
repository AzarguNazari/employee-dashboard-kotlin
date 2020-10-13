package com.employeeDashboard.controller.interfaces;

import com.employeeDashboard.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

interface UserControllerInterface {

    @PostMapping
    @Operation(summary = "create a new user")
    @ApiResponses(value = [ApiResponse(description = "Successfully created new user", responseCode = "201", content = Content(schema = Schema(implementation = ResponseEntity::class)))])
    fun createUser(@RequestBody user :User): ResponseEntity<*>

    @ApiResponses(value = [ApiResponse(description = "Get all the users", responseCode = "200", content = Content(schema = Schema(implementation = ResponseEntity::class)))])
    @Operation(summary = "get list of users")
    @GetMapping
    fun getAllusers(): ResponseEntity<*>

    @GetMapping("/{userID}")
    @Operation(summary = "get a specific user")
    @ApiResponses(value = [ApiResponse(description = "Get a user by ID", responseCode = "200", content = Content(schema = Schema(implementation = ResponseEntity::class)))])
    fun getUserById(@PathVariable userID: Int): ResponseEntity<*>

    @DeleteMapping("/{userID}")
    @Operation(summary = "delete a specific user")
    @ApiResponses(value = [ApiResponse(description = "Delete a user by ID", responseCode = "200", content = Content(schema = Schema(implementation = ResponseEntity::class)))])
    fun deleteUserById(@PathVariable userID: Int): ResponseEntity<*>

    @PutMapping("/{userID}")
    @Operation(summary = "update a specific user")
    @ApiResponses(value = [ApiResponse(description = "Update a user by ID", responseCode = "200", content = Content(schema = Schema(implementation = ResponseEntity::class)))])
    fun updateUser(@PathVariable userID: Int, @RequestBody user: User): ResponseEntity<*>
}