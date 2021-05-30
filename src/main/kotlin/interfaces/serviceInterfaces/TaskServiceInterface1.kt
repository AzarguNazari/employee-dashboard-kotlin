package interfaces.serviceInterfaces

import dashboard.models.jpa.Task
import models.jpa.Priority

interface TaskServiceInterface {
    fun deleteAll()
    fun addAllTasks(tasks: List<Task>)
    fun totalEmployees(): Long
    fun getTaskByPriority(priority: Priority): List<Task>
    fun findTaskByStatus(status: String): List<Task>
    fun count(): Long
}