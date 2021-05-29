//package com.dashboard;
//
//import com.dashboard.controllers.TaskController;
//import com.dashboard.models.JPA.Priority;
//import com.dashboard.models.JPA.Status;
//import com.dashboard.models.JPA.Task;
//import com.dashboard.services.TaskService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//public class EmployeeTasks {
//
//    @Mock
//    private TaskService taskService;
//
//    @InjectMocks
//    private TaskController taskController;
//
//    List<Task> tasks;
//
//    @Test
//    public void two_tasks_exist() throws Exception{
//        when(taskService.getAll()).thenReturn(tasks);
//
//        final ResponseEntity<?> task = taskController.getAllTasks();
//
//        assertNotNull(task);
//        assertThat(task.getStatusCode()).isEqualTo(HttpStatus.OK);
//        final List<Task> foundTask = (List<Task>) task.getBody();
//        assertNotNull(foundTask);
//
//        assertThat(foundTask).isEqualTo(tasks);
//
//    }
//
//    @Test
//    public void getAllTasks_returnTwoTasks() throws Exception{
//        when(taskService.getById(anyInt())).thenReturn(tasks.get(0));
//
//        final ResponseEntity<?> task = taskController.getTaskById(1);
//
//        assertNotNull(task);
//        assertThat(task.getStatusCode()).isEqualTo(HttpStatus.OK);
//        final Task foundTask = (Task) task.getBody();
//        assertThat(foundTask.getId()).isEqualTo(1);
//    }
//
//    @Test
//    public void createNewAccount_returnTrue() throws Exception {
//
//        Mockito.doNothing().when(taskService).save(tasks.get(0));
//        when(taskService.getById(anyInt())).thenReturn(tasks.get(0));
//
//        final ResponseEntity<?> createdTask = taskController.createTask(tasks.get(0));
//
//        assertNotNull(createdTask);
//
//        final ResponseEntity<?> taskById = taskController.getTaskById(1);
//        assertNotNull(taskById);
//
//        final Task task = (Task) taskById.getBody();
//        assertThat(task.getId()).isEqualTo(1);
//    }
//
//    @Test
//    void updateTask1_returnsNewUpdateTask(){
//
//        Task task2 = tasks.get(1);
//
//        Mockito.doNothing().when(taskService).update(1, task2);
//
//        final ResponseEntity<?> updateTask = taskController.updateTask(1, task2);
//
//        assertNotNull(updateTask);
//        assertThat(updateTask.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//    @Test
//    void deleteTask1_returnNO_CONTENT_status(){
//
//        Mockito.doNothing().when(taskService).delete(anyInt());
//
//        final ResponseEntity<?> updateTask = taskController.deleteTaskById(anyInt());
//
//        assertNotNull(updateTask);
//        assertThat(updateTask.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//
//
//    // -------- setups
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        tasks = generateTasks();
//    }
//
//    public List<Task> generateTasks(){
//        Task task1 = new Task();
//        task1.setId(1);
//        task1.setPercentage(50);
//        task1.setPriority(Priority.NORMAL);
//        task1.setStatus(Status.DONE);
//        task1.setDescription("clean all unused branches");
//        task1.setTaskname("Git Branch Cleaning");
//
//        Task task2 = new Task();
//        task2.setId(2);
//        task2.setPercentage(10);
//        task2.setPriority(Priority.HIGH);
//        task2.setStatus(Status.NOT_READY);
//        task2.setDescription("Create new branch for ticket 11");
//        task2.setTaskname("Ticket Creation");
//
//        Task task3 = new Task();
//        task3.setId(3);
//        task3.setPercentage(20);
//        task3.setPriority(Priority.LOW);
//        task3.setStatus(Status.NOT_READY);
//        task3.setDescription("clean all unused branches");
//        task3.setTaskname("Ticket Creation");
//
//        Task task4 = new Task();
//        task4.setPercentage(30);
//        task4.setPriority(Priority.HIGH);
//        task4.setStatus(Status.READY);
//        task4.setDescription("discuss with team members about ticket 1");
//        task4.setTaskname("Discussion about Ticket 1");
//
//        return Arrays.asList(task1, task2, task3, task4);
//    }
//}