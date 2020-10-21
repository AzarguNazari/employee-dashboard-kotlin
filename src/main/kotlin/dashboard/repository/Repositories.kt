package dashboard.repository

import dashboard.model.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AnnouncementRepository : JpaRepository<Announcement, Int>

interface AttendanceRepository : JpaRepository<Attendance, Int>

interface EmployeeRepository : JpaRepository<Employee, Int>

interface MessageRepository : JpaRepository<Message, Int>

interface RoleRepository : JpaRepository<Role, Int>

interface TaskRepository : JpaRepository<Task, Int> {
    fun findByPriority(priority: String): List<Task>
    fun findTasksByStatus(status: String): List<Task>
}

interface UserRepository : JpaRepository<User, Int> {
    fun findByUsername(username: String): Optional<User>
}
