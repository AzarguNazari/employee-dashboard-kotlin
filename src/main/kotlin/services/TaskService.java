package services;

import exceptions.EmployeeNotFoundException;
import interfaces.serviceInterfaces.CrudOperations;
import models.JPA.Priority;
import models.JPA.Task;
import com.dashboard.repositories.TaskRepository;
import interfaces.serviceInterfaces.TaskServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class TaskService implements CrudOperations<Task>, TaskServiceInterface {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }

    @Override
    public void addAllTasks(List<Task> tasks) {
        tasks.forEach(taskRepository::save);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getById(int id) {
        final Optional<Task> byId = taskRepository.findById(id);
        if(byId.isPresent()) return byId.get();
        else throw new EmployeeNotFoundException();
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    @Override
    public Long totalEmployees() {
        return taskRepository.count();
    }

    @Override
    public List<Task> getTaskByPriority(Priority priority) {
        return taskRepository.findByPriority(priority.toString());
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void update(int taskId, Task task) {
        Optional<Task> foundTask = taskRepository.findById(taskId);
        if(foundTask.isPresent()){
            task.setId(taskId);
            taskRepository.deleteById(taskId);
            taskRepository.save(task);
        }
    }

    @Override
    public List<Task> findTaskByStatus(String status) {
        return taskRepository.findByPriority(status);
    }

    @Override
    public boolean exist(int taskId) {
        return taskRepository.findById(taskId).isEmpty();
    }

    @Override
    public long count() {
        return taskRepository.count();
    }

    public void removeTask(int taskID){
        taskRepository.deleteById(taskID);
    }
}
