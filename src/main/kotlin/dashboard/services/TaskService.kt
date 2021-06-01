package dashboard.services

import dashboard.models.jpa.Task
import dashboard.exceptions.EmployeeNotFoundException
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.interfaces.serviceInterfaces.TaskServiceInterface
import dashboard.models.jpa.Priority
import org.springframework.stereotype.Service
import dashboard.repositories.TaskRepository
import java.util.*
import javax.transaction.Transactional

@Service

@Transactional
class TaskService(val taskRepository: TaskRepository) : CrudOperations<Task>, TaskServiceInterface {

    override fun deleteAll() {
        taskRepository.deleteAll()
    }

    override fun addAllTasks(tasks: List<Task>) {
        tasks.forEach(taskRepository::save)
    }

    override fun save(task: Task) {
        taskRepository.save(task)
    }

    override fun getById(id: Int): Task {
        val byId: Optional<Task> = taskRepository.findById(id)
        return if (byId.isPresent) byId.get() else throw EmployeeNotFoundException()
    }

    override fun all(): List<Task> = taskRepository.findAll()

    override fun totalEmployees(): Long {
        return taskRepository.count()
    }

    override fun getTaskByPriority(priority: Priority): List<Task> {
        return taskRepository.findByPriority(priority.toString())
    }

    override fun delete(id: Int) {
        taskRepository.deleteById(id)
    }

    override fun update(taskId: Int, task: Task) {
        val foundTask: Optional<Task> = taskRepository.findById(taskId)
        if (foundTask.isPresent) {
            task.id = taskId
            taskRepository.deleteById(taskId)
            taskRepository.save(task)
        }
    }

    override fun findTaskByStatus(status: String): List<Task> {
        return taskRepository.findByPriority(status)
    }

    override fun exist(taskId: Int): Boolean {
        return taskRepository.findById(taskId).isEmpty
    }

    override fun count(): Long {
        return taskRepository.count()
    }

    fun removeTask(taskID: Int) {
        taskRepository.deleteById(taskID)
    }
}