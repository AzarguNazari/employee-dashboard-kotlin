//package com.dashboard;
//
//import com.dashboard.models.JPA.Priority;
//import com.dashboard.models.JPA.Status;
//import com.dashboard.models.JPA.Task;
//import com.dashboard.repositories.TaskRepository;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class MessagesTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    private String TASK_URL = "http://localhost:" + this.port + "/v1/api/tasks";
//
//    @BeforeAll
//    public void contextLoads(){
//        generateTasks().forEach(taskRepository::save);
//        assertThat(taskRepository.count()).isEqualTo(4);
//    }
//
//    @Test
//    public void addNewAccount() throws URISyntaxException {
//        Task task = generateTask(50, Priority.HIGH, Status.DONE, "Git Branch Cleaning", "clean all unused branches");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        HttpEntity<Task> request = new HttpEntity<>(task, headers);
//        ResponseEntity<String> result = this.restTemplate.postForEntity(new URI(TASK_URL), request, String.class);
//        Assertions.assertEquals(201, result.getStatusCodeValue());
//    }
//
//    @Test
//    public void getAllList() throws URISyntaxException {
//        // load tasks
//        beforeTask();
//
//        final String baseUrl = "http://localhost:" + this.port + "/v1/api/tasks";
//        URI uri = new URI(baseUrl);
//        final ResponseEntity<List> tasks = this.restTemplate.getForEntity(uri, List.class);
//        assertThat(tasks).isNotNull();
//        assertThat(tasks.getBody()).hasSize(4);
//        Assertions.assertEquals(200, tasks.getStatusCodeValue());
//    }
//
//    @Test
//    public void updateTask() throws URISyntaxException {
//
//        beforeTask();
//
//        final String baseUrl = "http://localhost:" + this.port + "/v1/api/tasks/1";
//        URI uri = new URI(baseUrl);
//        Task task = new Task();
//        task.setPercentage(100);
//        task.setPriority(Priority.HIGH);
//        task.setStatus(Status.DONE);
//        task.setDescription("clean all unused branches");
//        task.setTaskname("Git Branch Cleaning");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        HttpEntity<Task> request = new HttpEntity<>(task, headers);
//        this.restTemplate.put(uri, request);
//    }
//
//    @AfterAll
//    public void cleanTestWorkspace(){
//        taskRepository.deleteAll();
//        assertThat(taskRepository.count()).isEqualTo(0);
//    }
//
//    @Test
//    public void deleteTask(){
//
//    }
//
//    @Test
//    public void deleteAllTask() {
//
//    }
//
//    public void beforeTask(){
//        taskRepository.deleteAll();
//        generateTasks().forEach(taskRepository::save);
//    }
//
//    private Task generateTask(int percentage, Priority priority, Status status, String taskName, String description){
//        Task task1 = new Task();
//        task1.setPercentage(percentage);
//        task1.setPriority(priority);
//        task1.setStatus(status);
//        task1.setDescription(description);
//        task1.setTaskname(taskName);
//        return task1;
//    }
//
//
//    public List<Task> generateTasks(){
//        return Arrays.asList(
//                generateTask(50, Priority.NORMAL, Status.NOT_READY, "Git Branch Cleaning", "clean all unused branches"),
//                generateTask(10, Priority.HIGH, Status.DONE, "Ticket Creation", "Create new branch for ticket 11"),
//                generateTask(20, Priority.LOW, Status.NOT_READY, "Ticket Creation","clean all unused branches"),
//                generateTask(30, Priority.HIGH, Status.READY, "Discussion about Ticket 1", "discuss with team members about ticket 1")
//        );
//    }
//}
//
