package dashboard.services

import dashboard.models.jpa.EmployeeDto.password1
import dashboard.models.jpa.EmployeeDto.password2
import dashboard.models.jpa.EmployeeDto.username
import dashboard.models.jpa.EmployeeDto.firstName
import dashboard.models.jpa.EmployeeDto.lastName
import dashboard.models.jpa.EmployeeDto.salary
import dashboard.models.jpa.EmployeeDto.position
import dashboard.models.jpa.Employee.id
import dashboard.models.jpa.Employee.tasks
import dashboard.repositories.AnnouncementRepository
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.exceptions.AnnouncementNotFoundException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import dashboard.repositories.AttendanceRepository
import dashboard.services.AttendanceService
import dashboard.exceptions.AttendanceNotFoundException
import lombok.extern.log4j.Log4j2
import dashboard.interfaces.serviceInterfaces.ChatServiceInterface
import dashboard.interfaces.serviceInterfaces.DashboardServiceInterface
import dashboard.repositories.EmployeeRepository
import kotlin.Throws
import dashboard.exceptions.InvalidInput
import dashboard.services.DashboardService
import dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface
import dashboard.repositories.TaskRepository
import dashboard.exceptions.BadRequestException
import dashboard.exceptions.EmployeeNotFoundException
import dashboard.exceptions.TaskNotFoundException
import dashboard.interfaces.serviceInterfaces.TaskServiceInterface
import dashboard.interfaces.serviceInterfaces.UserServiceInterface
import dashboard.repositories.UserRepository
import dashboard.exceptions.UserNotFoundException
import dashboard.models.jpa.*
import org.springframework.stereotype.Service
import java.util.function.Consumer
import javax.transaction.Transactional

@Service
@Slf4j
@Transactional
class TaskService(private val taskRepository: TaskRepository) : CrudOperations<Task?>, TaskServiceInterface {
    override fun deleteAll() {
        taskRepository.deleteAll()
    }

    override fun addAllTasks(tasks: List<Task?>?) {
        tasks!!.forEach(Consumer { entity: Task -> taskRepository.save(entity) })
    }

    override fun save(task: Task) {
        taskRepository.save(task)
    }

    override fun getById(id: Int): Task {
        val byId = taskRepository.findById(id)
        return if (byId.isPresent) byId.get() else throw EmployeeNotFoundException()
    }

    val all: List<Task>
        get() = taskRepository.findAll()

    override fun totalEmployees(): Long? {
        return taskRepository.count()
    }

    override fun getTaskByPriority(priority: Priority?): List<Task?>? {
        return taskRepository.findByPriority(priority.toString())
    }

    override fun delete(id: Int) {
        taskRepository.deleteById(id)
    }

    override fun update(taskId: Int, task: Task) {
        val foundTask = taskRepository.findById(taskId)
        if (foundTask.isPresent) {
            task.setId(taskId)
            taskRepository.deleteById(taskId)
            taskRepository.save(task)
        }
    }

    override fun findTaskByStatus(status: String?): List<Task?>? {
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