package interfaces.controllerInterfaces

import dashboard.models.jpa.Announcement
import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Announcements")
interface AnnouncementControllerInterface {
    @PostMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created a new announcement",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createAnnouncement(@RequestBody announcement: Announcement?): ResponseEntity<*>?

    @get:ApiResponses(
        value = [ApiResponse(
            description = "Get all announcements",
            responseCode = "200",
            content = arrayOf(
                Content(
                    schema = Schema(implementation = ResponseEntity::class)
                )
            )
        )]
    )
    @get:GetMapping
    val allEmployees: ResponseEntity<*>?

    @GetMapping("/{announcementID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get an attendance with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getEmployeeById(@PathVariable announcementID: Int?): ResponseEntity<*>?

    @DeleteMapping("/{announcementID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete an announcement with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteEmployeeById(@PathVariable announcementID: Int?): ResponseEntity<*>?

    @PutMapping("/{announcementID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update an announcement with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateEmployee(@PathVariable announcementID: Int?, @RequestBody announcement: Announcement?): ResponseEntity<*>?
}