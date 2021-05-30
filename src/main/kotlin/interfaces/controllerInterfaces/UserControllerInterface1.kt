package interfaces.controllerInterfaces

import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import models.jpa.User
import org.springframework.web.bind.annotation.*

@Tag(name = "Users")
interface UserControllerInterface {
    @PostMapping
    @Operation(summary = "create a new user")
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created new user",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createUser(@RequestBody user: User?): ResponseEntity<*>?

    @get:ApiResponses(
        value = [ApiResponse(
            description = "Get all the users",
            responseCode = "200",
            content = arrayOf(
                Content(
                    schema = Schema(implementation = ResponseEntity::class)
                )
            )
        )]
    )
    @get:Operation(summary = "get list of users")
    @get:GetMapping
    val allUsers: ResponseEntity<*>?

    @GetMapping("/{userID}")
    @Operation(summary = "get a specific user")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get a user by ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getUserById(@PathVariable userID: Int?): ResponseEntity<*>?

    @DeleteMapping("/{userID}")
    @Operation(summary = "delete a specific user")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete a user by ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteUserById(@PathVariable userID: Int?): ResponseEntity<*>?

    @PutMapping("/{userID}")
    @Operation(summary = "update a specific user")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update a user by ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateUser(@PathVariable userID: Int?, @RequestBody user: User?): ResponseEntity<*>?
}