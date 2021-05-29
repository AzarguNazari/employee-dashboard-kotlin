package dashboard.api.interfaces

import dashboard.models.Attendance
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface AttendanceControllerInterface {
    @PostMapping
    fun createAttendance(@RequestBody attendance: Attendance): ResponseEntity<*>

    @GetMapping
    fun getAllAttendances(): ResponseEntity<*>

    @GetMapping("/{attendanceID}")
    fun getAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @DeleteMapping("/{attendanceID}")
    fun deleteAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @PutMapping("/{attendanceID}")
    fun updateAttendance(@PathVariable attendanceID: Int, @RequestBody attendance: Attendance): ResponseEntity<*>
}