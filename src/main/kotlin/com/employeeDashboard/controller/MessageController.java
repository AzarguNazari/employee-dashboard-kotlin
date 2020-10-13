package com.employeeDashboard.controller;

import com.dashboard.controller.interfaces.EmployeeControllerInterface;
import com.dashboard.exception.*;
import com.dashboard.model.Employee;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@Tag(name = "Messages")
@Log4j2
public class MessageController implements EmployeeControllerInterface {

    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> getAllEmployees(Pageable pageable) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> getEmployeeById(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer employeeId, Employee employee) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
