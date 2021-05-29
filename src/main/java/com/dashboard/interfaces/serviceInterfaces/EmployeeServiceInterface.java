package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.models.JPA.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    void deleteAllEmployees();

    void addAllEmployees(List<Employee> users);

    Optional<Employee> getByUsername(String username);

    void assignTask(Integer employeeId, Integer taskID);

    void unassignTask(Integer employeeId, Integer taskID);

    long count();
}
