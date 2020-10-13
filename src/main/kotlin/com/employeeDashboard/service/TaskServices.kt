
import com.employeeDashboard.repository.TaskRepository
import com.employeeDashboard.service.DAO
import org.springframework.scheduling.config.Task
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
@Transactional
class TaskService(val taskRepository: TaskRepository) : DAO<Task> {

    fun removeTask(taskID: Int) {
        taskRepository.deleteById(taskID)
    }

    override fun save(t: Task) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, t: Task) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Task {
        TODO("Not yet implemented")
    }
}