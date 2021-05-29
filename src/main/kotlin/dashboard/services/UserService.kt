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

@Service
class UserService : UserServiceInterface {
    @Autowired
    private val userRepository: UserRepository? = null
    override fun save(user: User?) {
        userRepository!!.save(user)
    }

    override fun delete(userId: Int?) {
        val byId = userRepository!!.findById(userId!!)
        if (byId.isEmpty) throw UserNotFoundException()
        userRepository.deleteById(userId)
    }

    override fun update(userId: Int?, user: User?) {
        val byId = userRepository!!.findById(userId!!)
        if (byId.isEmpty) throw UserNotFoundException()
        user.setId(userId)
        userRepository.deleteById(userId)
        userRepository.save(user)
    }

    override fun exist(userId: Int?): Boolean {
        return userRepository!!.findById(userId!!).isPresent
    }

    val allUsers: List<User>
        get() = userRepository!!.findAll()

    override fun getUserById(userId: Int?): User? {
        val byId = userRepository!!.findById(userId!!)
        if (byId.isEmpty) throw UserNotFoundException()
        return byId.get()
    }
}