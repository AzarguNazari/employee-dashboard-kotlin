package com.employeeDashboard.controller;

import com.dashboard.controller.interfaces.EmployeeControllerInterface;
import com.dashboard.exception.*;
import com.dashboard.model.Employee;
import com.dashboard.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/announcements")
@Tag(name = "Announcements")
@Log4j2
public class AnnouncementsController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        try{
            employeeService.addNewEmployee(employee);
            log.debug("New employee {} is added", employee);
            return new ResponseEntity<>("New employee is created", HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllEmployees(Pageable pageable) {
        try{
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeById(Integer id) {
        try{
            return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
        }
        catch(EmployeeNotFoundException ex){
            log.debug("employee {} is already existed", id);
            return new ResponseEntity<>(new ApiError("employee with id " + id + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer id) {
        try{
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(EmployeeNotFoundException ex){
            log.debug("employee {} is already existed", id);
            return new ResponseEntity<>(new ApiError("employee with id " + id + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer employeeId, Employee employee) {
        try{
            employeeService.updateEmployee(employeeId, employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(EmployeeNotFoundException ex){
            log.debug("employee {} is already existed", employeeId);
            return new ResponseEntity<>(new ApiError("attendance with id " + employeeId + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> assignTask(Integer employeeID, Integer taskID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> unassignTask(Integer employeeID, Integer taskID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
