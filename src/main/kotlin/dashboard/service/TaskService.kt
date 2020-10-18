package dashboard.service

import dashboard.exception.TaskNotFoundException
import dashboard.model.Task
import dashboard.repository.TaskRepository
import org.springframework.stereotype.Service


@Service
class TaskService(val taskRepository: TaskRepository) : DAO<Task> {

    override fun save(t: Task) {
        taskRepository.save(t)
    }

    override fun delete(id: Int) {
        taskRepository.deleteById(id)
    }

    override fun update(id: Int, task: Task) {
        if(exist(id)){
            task.id = id
            taskRepository.deleteById(id)
            taskRepository.save(task)
        }
        throw TaskNotFoundException()
    }

    override fun getAll() = taskRepository.findAll().toList()

    override fun getById(id: Int) = taskRepository.findById(id)?.get()

    override fun exist(id: Int) = taskRepository.existsById(id)

    fun findTaskByStatus(status: String) = taskRepository.findTasksByStatus(status)
}