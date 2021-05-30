package services

import com.dashboard.repositories.TaskRepository
import interfaces.serviceInterfaces.CrudOperations
import interfaces.serviceInterfaces.TaskServiceInterface
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Slf4j
@Transactional
class TaskService(taskRepository: TaskRepository) : CrudOperations<Task>, TaskServiceInterface {
    private val taskRepository: TaskRepository
    override fun deleteAll() {
        taskRepository.deleteAll()
    }

    override fun addAllTasks(tasks: List<Task?>) {
        tasks.forEach(taskRepository::save)
    }

    override fun save(task: Task) {
        taskRepository.save(task)
    }

    override fun getById(id: Int): Task {
        val byId: Optional<Task> = taskRepository.findById(id)
        return if (byId.isPresent) byId.get() else throw EmployeeNotFoundException()
    }

    override val all: List<T>
        get() = taskRepository.findAll()

    override fun totalEmployees(): Long {
        return taskRepository.count()
    }

    override fun getTaskByPriority(priority: Priority): List<Task?> {
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

    override fun findTaskByStatus(status: String?): List<Task?> {
        return taskRepository.findByPriority(status)
    }

    override fun exist(taskId: Int): Boolean {
        return taskRepository.findById(taskId).isEmpty()
    }

    override fun count(): Long {
        return taskRepository.count()
    }

    fun removeTask(taskID: Int) {
        taskRepository.deleteById(taskID)
    }

    init {
        this.taskRepository = taskRepository
    }
}