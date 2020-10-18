package dashboard.service.interfaces

import dashboard.model.Priority
import dashboard.model.Task

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