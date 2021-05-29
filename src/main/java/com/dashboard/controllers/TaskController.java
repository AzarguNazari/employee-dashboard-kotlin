//package dashboard.controllers;
//
//import dashboard.interfaces.controllerInterfaces.TaskControllerInterface;
//import dashboard.exceptions.ApiError;
//import dashboard.exceptions.EmployeeNotFoundException;
//import dashboard.models.JPA.Task;
//import dashboard.services.TaskService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/v1/tasks")
//public class TaskController implements TaskControllerInterface {
//
//    @Autowired
//    private TaskService taskService;
//
//    @Override
//    public ResponseEntity<?> createTask(Task task) {
//        try{
//            taskService.save(task);
//            log.debug("New task {} is added", task);
//            return new ResponseEntity<>("New task is created", HttpStatus.CREATED);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getAllTasks() {
//        try{
//            return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getTaskById(Integer id) {
//        try{
//            return new ResponseEntity<>(taskService.getById(id), HttpStatus.OK);
//        }
//        catch(EmployeeNotFoundException ex){
//            log.debug("account {} is already existed", id);
//            return new ResponseEntity<>(new ApiError("account with id " + id + " is doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getTaskByStatus(String status) {
//        try{
//            return new ResponseEntity<>(taskService.findTaskByStatus(status), HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> deleteTaskById(Integer id) {
//        try{
//            taskService.delete(id);
//            return new ResponseEntity<>("Task with id " + id + " is deleted", HttpStatus.NO_CONTENT);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> updateTask(Integer taskID, Task task) {
//        try{
//            taskService.update(taskID, task);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
