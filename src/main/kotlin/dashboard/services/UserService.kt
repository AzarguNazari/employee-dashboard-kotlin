package dashboard.services

import dashboard.exception.UserNotFoundException
import dashboard.models.User
import dashboard.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) : DAO<User> {

    override fun save(user: User) {
        userRepository.save(user)
    }

    override fun delete(id: Int) {
        userRepository.deleteById(id)
    }

    override fun update(id: Int, user: User) {
        if(exist(id)){
            user.id = id
            userRepository.deleteById(id)
            userRepository.save(user)
        }
        throw UserNotFoundException()
    }

    override fun getAll() = userRepository.findAll().toList()

    override fun getById(id: Int) = userRepository.findById(id)?.get()

    override fun exist(id: Int) = userRepository.existsById(id)
}
