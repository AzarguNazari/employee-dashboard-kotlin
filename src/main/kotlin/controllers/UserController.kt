package controllers;//package dashboard.controllers;
//
//import dashboard.interfaces.controllerInterfaces.UserControllerInterface;
//import dashboard.exceptions.UserNotFoundException;
//import dashboard.models.JPA.User;
//import dashboard.services.UserService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Log4j2
//@RestController
//@RequestMapping("/api/v1/users")
//public class UserController implements UserControllerInterface {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public ResponseEntity<?> createUser(User user) {
//        userService.save(user);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @Override
//    public ResponseEntity<?> getAllUsers() {
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<?> getUserById(Integer userID) {
//        try{
//            return new ResponseEntity<>(userService.getUserById(userID), HttpStatus.OK);
//        }
//        catch(UserNotFoundException ex){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> deleteUserById(Integer userID) {
//        try{
//            userService.delete(userID);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(UserNotFoundException ex){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> updateUser(Integer userID, User user) {
//        try{
//            userService.update(userID, user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(UserNotFoundException ex){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
