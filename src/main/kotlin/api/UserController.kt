package api

import exceptions.UserNotFoundException
import interfaces.controllerInterfaces.UserControllerInterface
import lombok.extern.log4j.Log4j2
import models.jpa.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import services.UserService


@RestController
@RequestMapping("/api/v1/users")
class UserController(val userService: UserService) : UserControllerInterface {

    override fun createUser(user: User): ResponseEntity<*> {
        userService.save(user);
        return ResponseEntity<User>(HttpStatus.CREATED);
    }

    override fun allUsers(): ResponseEntity<*> {
        return ResponseEntity<List<User>>(userService.allUsers, HttpStatus.OK);
    }

    override fun getUserById(userID: Int): ResponseEntity<*> {
        return try{
            ResponseEntity<User>(userService.getUserById(userID), HttpStatus.OK);
        } catch(ex: UserNotFoundException){
            ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    override fun deleteUserById(userID: Int): ResponseEntity<*> {
        return try{
            userService.delete(userID);
            ResponseEntity<Void>(HttpStatus.OK);
        } catch(ex: UserNotFoundException){
            ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    override fun updateUser(userID: Int, user: User): ResponseEntity<*> {
        return try{
            userService.update(userID, user);
            ResponseEntity<Void>(HttpStatus.OK);
        } catch(ex: UserNotFoundException){
            ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
