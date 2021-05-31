package interfaces.controllerInterfaces

import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import models.jpa.Attendance
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@Tag(name = "Attendances")
interface AttendanceControllerInterface {
    @PostMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Successfully created new attendance",
            responseCode = "201",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun createAttendance(@RequestBody attendance: Attendance): ResponseEntity<*>

    @GetMapping
    @ApiResponses(
        value = [ApiResponse(
            description = "Get all attendances",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getAllAttendances(pageable: Pageable): ResponseEntity<*>

    @GetMapping("/{attendanceID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Get an attendance task with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun getAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @DeleteMapping("/{attendanceID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Delete an attendance with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun deleteAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @PutMapping("/{attendanceID}")
    @ApiResponses(
        value = [ApiResponse(
            description = "Update an attendance with specific ID",
            responseCode = "200",
            content = arrayOf(Content(schema = Schema(implementation = ResponseEntity::class)))
        )]
    )
    fun updateAttendance(@PathVariable attendanceID: Int, @RequestBody attendance: Attendance): ResponseEntity<*>
}