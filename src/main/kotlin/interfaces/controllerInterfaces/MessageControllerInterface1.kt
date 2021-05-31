package interfaces.controllerInterfaces

import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import models.jpa.Message
import org.springframework.web.bind.annotation.*

@Tag(name = "Messages")
interface MessageControllerInterface {
    @PostMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created a new message",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createMessage(@RequestBody message: Message): ResponseEntity<*>

    @ApiResponses(
        value = [ApiResponse(
            description = "Get all messages",
            responseCode = "200",
            content = arrayOf(
                Content(
                    schema = Schema(implementation = ResponseEntity::class)
                )
            )
        )]
    )
    @GetMapping
    fun allMessages(): ResponseEntity<*>

    @GetMapping("/{messageID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get a specific message with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getMessageById(@PathVariable messageID: Int): ResponseEntity<*>

    @DeleteMapping("/{messageID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete a message with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteMessageById(@PathVariable messageID: Int): ResponseEntity<*>

    @PutMapping("/{messageID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update a message with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateMessage(@PathVariable messageID: Int, @RequestBody Message: Message): ResponseEntity<*>
}