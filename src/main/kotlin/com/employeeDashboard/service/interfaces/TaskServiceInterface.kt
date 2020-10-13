package com.employeeDashboard.service.interfaces

import com.employeeDashboard.Priority
import com.employeeDashboard.Task

interface TaskServiceInterface {
    fun deleteAllTasks()
    fun addAllTasks(tasks: List<Task>)
    fun addNewTask(task: Task)
    fun getTaskById(id: Int): Task
    fun getAllTasks(): List<Task>
    fun totalEmployees(): Long
    fun getTaskByPriority(priority: Priority): List<Task>
    fun deleteTaskById(id: Int)
    fun updateTask(employeeId: Int, task: Task)
    fun findTaskByStatus(status: String): List<Task>
}