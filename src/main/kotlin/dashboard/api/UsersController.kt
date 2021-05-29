package dashboard.api


import dashboard.api.interfaces.UserControllerInterface
import dashboard.exception.UserNotFoundException
import dashboard.models.User
import dashboard.services.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users")
class UsersController( val userService: UserService) : UserControllerInterface {

    val logger: Logger = LoggerFactory.getLogger(UsersController::class.java)


    override fun createUser(user: User): ResponseEntity<*> {
        userService.save(user)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }

    override fun getAllusers(): ResponseEntity<*> = ResponseEntity<Any?>(userService.getAll(), HttpStatus.OK)

    override fun getUserById(userID: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(userService.getById(userID), HttpStatus.OK)
        } catch (ex: UserNotFoundException) {
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        }
    }

    override fun deleteUserById(userID: Int): ResponseEntity<*> {
        return try {
            userService.delete(userID)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: UserNotFoundException) {
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        }
    }

    override fun updateUser(userID: Int, user: User): ResponseEntity<*> {
        return try {
            userService.update(userID, user)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: UserNotFoundException) {
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        }
    }

}