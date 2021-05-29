package com.dashboard.services;

import com.dashboard.exceptions.BadRequestException;
import com.dashboard.exceptions.EmployeeNotFoundException;
import com.dashboard.exceptions.TaskNotFoundException;
import com.dashboard.interfaces.serviceInterfaces.CrudOperations;
import com.dashboard.models.JPA.Employee;
import com.dashboard.repositories.EmployeeRepository;
import com.dashboard.repositories.TaskRepository;
import com.dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements CrudOperations<Employee>, EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    @Override
    public void addAllEmployees(List<Employee> users){
        employeeRepository.saveAll(users);
    }

    @Override
    public void save(Employee employee){
        if(employee.getId() != null){
            final Optional<Employee> byId = employeeRepository.findById(employee.getId());
            if(byId.isPresent()) throw new BadRequestException();
        }
        else{
            employeeRepository.save(employee);
        }
    }

    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id){
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Optional<Employee> getByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

    @Override
    public void delete(int employeeID){
        final Optional<Employee> employee = employeeRepository.findById(employeeID);
        if(employee.isEmpty()) throw new EmployeeNotFoundException();
        employeeRepository.deleteById(employeeID);
    }

    @Override
    public void update(int employeeId, Employee employee) {
        final Optional<Employee> emp = employeeRepository.findById(employeeId);
        if(emp.isEmpty()) throw new EmployeeNotFoundException();
        employee.setId(employeeId);
        employeeRepository.deleteById(employeeId);
        employeeRepository.save(employee);
    }

    @Override
    public void assignTask(Integer employeeId, Integer taskID) {
        employeeRepository.findById(employeeId)
                .orElseThrow(EmployeeNotFoundException::new)
                .getTasks()
                .add(taskRepository.findById(employeeId)
                        .orElseThrow(TaskNotFoundException::new)
                );
    }

    @Override
    public void unassignTask(Integer employeeId, Integer taskID) {
        employeeRepository.findById(employeeId)
                          .orElseThrow(EmployeeNotFoundException::new)
                          .getTasks()
                          .remove(taskRepository.findById(employeeId)
                                                .orElseThrow(TaskNotFoundException::new)
                          );
    }

    @Override
    public boolean exist(int employeeId) {
        return employeeRepository.findById(employeeId).isPresent();
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

}
