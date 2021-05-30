package services

import com.dashboard.repositories.UserRepository
import interfaces.serviceInterfaces.UserServiceInterface
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService : UserServiceInterface {
    @Autowired
    private val userRepository: UserRepository? = null
    override fun save(user: User?) {
        userRepository.save(user)
    }

    override fun delete(userId: Int?) {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        userRepository.deleteById(userId)
    }

    override fun update(userId: Int?, user: User) {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        user.setId(userId)
        userRepository.deleteById(userId)
        userRepository.save(user)
    }

    override fun exist(userId: Int?): Boolean {
        return userRepository.findById(userId).isPresent()
    }

    override val allUsers: List<User?>
        get() = userRepository.findAll()

    override fun getUserById(userId: Int?): User {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        return byId.get()
    }
}