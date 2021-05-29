package com.dashboard.repositories;

import com.dashboard.models.JPA.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByPriority(String priority);
    List<Task> findTasksByStatus(String status);
}
