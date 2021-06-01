package dashboard.repositories

import dashboard.models.jpa.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Int> {
    fun findByPriority(priority: String): List<Task>
    fun findTasksByStatus(status: String): List<Task>
}