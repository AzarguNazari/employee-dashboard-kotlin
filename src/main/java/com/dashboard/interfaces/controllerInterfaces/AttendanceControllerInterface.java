package com.dashboard.interfaces.controllerInterfaces;

import com.dashboard.models.JPA.Attendance;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Attendances")
public interface AttendanceControllerInterface {

    @PostMapping
    @ApiResponses(value = {@ApiResponse(description = "Successfully created new attendance",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createAttendance(@RequestBody Attendance attendance);

    @GetMapping
    @ApiResponses(value = {@ApiResponse(description = "Get all attendances",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllAttendances(Pageable pageable);

    @GetMapping("/{attendanceID}")
    @ApiResponses(value = {@ApiResponse(description = "Get an attendance task with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAttendanceById(@PathVariable Integer attendanceID);

    @DeleteMapping("/{attendanceID}")
    @ApiResponses(value = {@ApiResponse(description = "Delete an attendance with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteAttendanceById(@PathVariable Integer attendanceID);

    @PutMapping("/{attendanceID}")
    @ApiResponses(value = {@ApiResponse(description = "Update an attendance with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateAttendance(@PathVariable Integer attendanceID, @RequestBody Attendance attendance);
}
