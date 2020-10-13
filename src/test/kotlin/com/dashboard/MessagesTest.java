package com.dashboard;//package com.dashboard;
//
//import com.dashboard.model.Priority;
//import com.dashboard.model.Status;
//import com.dashboard.model.Task;
//import com.dashboard.repository.TaskRepository;
//import org.junit.Ignore;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
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
//
//@Ignore
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
//    @BeforeAll
//    public void contextLoads(){
//        generateTasks().forEach(taskRepository::save);
//        assertThat(taskRepository.count()).isEqualTo(4);
//    }
//
//    @Test
//    public void addNewAccount() throws URISyntaxException {
//        final String baseUrl = "http://localhost:" + this.port + "/v1/api/tasks";
//        URI uri = new URI(baseUrl);
//        Task task = new Task();
//        task.setPercentage(50);
//        task.setPriority(Priority.HIGH);
//        task.setStatus(Status.DONE);
//        task.setDescription("clean all unused branches");
//        task.setTaskname("Git Branch Cleaning");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        HttpEntity<Task> request = new HttpEntity<>(task, headers);
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
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
//    public List<Task> generateTasks(){
//        Task task1 = new Task();
//        task1.setPercentage(50);
//        task1.setPriority(Priority.NORMAL);
//        task1.setStatus(Status.DONE);
//        task1.setDescription("clean all unused branches");
//        task1.setTaskname("Git Branch Cleaning");
//
//        Task task2 = new Task();
//        task2.setPercentage(10);
//        task2.setPriority(Priority.HIGH);
//        task2.setStatus(Status.NOT_READY);
//        task2.setDescription("Create new branch for ticket 11");
//        task2.setTaskname("Ticket Creation");
//
//        Task task3 = new Task();
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
//
