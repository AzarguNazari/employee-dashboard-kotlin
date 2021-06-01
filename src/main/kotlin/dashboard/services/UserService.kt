package dashboard.services

import dashboard.exceptions.UserNotFoundException
import dashboard.interfaces.serviceInterfaces.UserServiceInterface
import dashboard.models.jpa.User
import org.springframework.stereotype.Service
import dashboard.repositories.UserRepository
import java.util.*

@Service
class UserService(val userRepository: UserRepository) : UserServiceInterface {
    
    override fun save(user: User) {
        userRepository.save(user)
    }

    override fun delete(userId: Int) {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        userRepository.deleteById(userId)
    }

    @Throws(UserNotFoundException::class)
    override fun update(userId: Int, user: User) {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        user.id = userId
        userRepository.deleteById(userId)
        userRepository.save(user)
    }

    override fun exist(userId: Int): Boolean {
        return userRepository.findById(userId).isPresent
    }

    override val allUsers: List<User>
        get() = userRepository.findAll()

    override fun getUserById(userId: Int): User {
        val byId: Optional<User> = userRepository.findById(userId)
        if (byId.isEmpty) throw UserNotFoundException()
        return byId.get()
    }
}