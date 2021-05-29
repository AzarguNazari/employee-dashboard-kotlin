package interfaces.serviceInterfaces;

import models.JPA.Priority;
import models.JPA.Task;

import java.util.List;

public interface TaskServiceInterface {

    void deleteAll();

    void addAllTasks(List<Task> tasks);

    Long totalEmployees();

    List<Task> getTaskByPriority(Priority priority);

    List<Task> findTaskByStatus(String status);

    long count();
}
