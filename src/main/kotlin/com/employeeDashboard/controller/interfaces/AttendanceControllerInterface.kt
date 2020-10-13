package com.employeeDashboard.controller.interfaces

import com.employeeDashboard.Attendance
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface AttendanceControllerInterface {
    @PostMapping
    fun createAttendance(@RequestBody attendance: Attendance): ResponseEntity<*>

    @GetMapping
    fun getAllAttendances(pageable: Pageable): ResponseEntity<*>

    @GetMapping("/{attendanceID}")
    fun getAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @DeleteMapping("/{attendanceID}")
    fun deleteAttendanceById(@PathVariable attendanceID: Int): ResponseEntity<*>

    @PutMapping("/{attendanceID}")
    fun updateAttendance(@PathVariable attendanceID: Int, @RequestBody attendance: Attendance): ResponseEntity<*>
}