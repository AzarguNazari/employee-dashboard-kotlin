package dashboard.interfaces.serviceInterfaces

import dashboard.models.jpa.User

interface UserServiceInterface {
    fun save(user: User)
    fun delete(userId: Int)
    fun update(userId: Int, user: User)
    fun exist(userId: Int): Boolean
    val allUsers: List<User>
    fun getUserById(userId: Int): User
}