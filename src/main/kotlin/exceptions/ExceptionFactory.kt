package exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ExceptionFactory {
    fun EMPLOYEE_NOT_FOUND(employeeID: Int): ResponseEntity<*> {
        return ResponseEntity(
            ApiError("Employee with ID $employeeID is not found", HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND
        )
    }

    fun TASK_NOT_FOUND(taskID: Int): ResponseEntity<*> {
        return ResponseEntity(ApiError("Task with ID $taskID is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
    }

    fun INTERNAL_EXCEPTION(): ResponseEntity<*> {
        return ResponseEntity(
            ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    fun ATTENDANCE_NOT_FOUND(attendanceID: Int): ResponseEntity<*> {
        return ResponseEntity(
            ApiError("Attendance with ID $attendanceID is not found", HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND
        )
    }

    fun ANNOUNCEMENT_NOT_FOUND(announcementID: Int): ResponseEntity<*> {
        return ResponseEntity(
            ApiError("Announcement with ID $announcementID is not found", HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND
        )
    }
}