package com.employeeDashboard.controller.interfaces

import com.employeeDashboard.Task
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface TaskControllerInterface {
    @PostMapping
    fun createTask(@RequestBody task: Task?): ResponseEntity<*>?

    @get:GetMapping
    val allTasks: ResponseEntity<*>?

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Int?): ResponseEntity<*>?

    @GetMapping("/status/{status}")
    fun getTaskByStatus(@PathVariable status: String?): ResponseEntity<*>?

    @DeleteMapping("/{id}")
    fun deleteTaskById(@PathVariable id: Int?): ResponseEntity<*>?

    @PutMapping("/{id}")
    fun updateTask(@PathVariable employeeId: Int?, @RequestBody task: Task?): ResponseEntity<*>?
}