package interfaces.controllerInterfaces;

import models.JPA.Message;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Messages")
public interface MessageControllerInterface {

    @PostMapping
    @ApiResponses(value = {@ApiResponse(description = "Successfully created a new message",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createMessage(@RequestBody Message message);

    @GetMapping
    @ApiResponses(value = {@ApiResponse(description = "Get all messages",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllMessages();

    @GetMapping("/{messageID}")
    @ApiResponses(value = {@ApiResponse(description = "Get a specific message with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getMessageById(@PathVariable Integer messageID);

    @DeleteMapping("/{messageID}")
    @ApiResponses(value = {@ApiResponse(description = "Delete a message with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteMessageById(@PathVariable Integer messageID);

    @PutMapping("/{messageID}")
    @ApiResponses(value = {@ApiResponse(description = "Update a message with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateMessage(@PathVariable Integer messageID, @RequestBody Message Message);
}
