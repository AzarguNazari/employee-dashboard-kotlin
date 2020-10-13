package com.employeeDashboard.controller;

import com.dashboard.controller.interfaces.AttendanceControllerInterface;
import com.dashboard.exception.ApiError;
import com.dashboard.exception.AttendanceNotFoundException;
import com.dashboard.model.Attendance;
import com.dashboard.service.AttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance")
@Tag(name = "Attendance")
@Log4j2
public class AttendanceController implements AttendanceControllerInterface {

    @Autowired
    private AttendanceService attendanceService;


    @Override
    public ResponseEntity<?> createAttendance(Attendance attendance) {
        try{
            attendanceService.save(attendance);
            log.debug("New task {} is added", attendance);
            return new ResponseEntity<>("New attendance is added", HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllAttendances(Pageable pageable) {
        try{
            return new ResponseEntity<>(attendanceService.getAllAttendances(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAttendanceById(Integer attendanceID) {
        try{
            return new ResponseEntity<>(attendanceService.getAttendanceById(attendanceID), HttpStatus.OK);
        }
        catch(AttendanceNotFoundException ex){
            log.debug("attendance {} is already existed", attendanceID);
            return new ResponseEntity<>(new ApiError("attendance with id " + attendanceID + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteAttendanceById(Integer attendanceID) {
        try{
            attendanceService.delete(attendanceID);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(AttendanceNotFoundException ex){
            log.debug("attendance {} is already existed", attendanceID);
            return new ResponseEntity<>(new ApiError("attendance with id " + attendanceID + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateAttendance(Integer attendanceID, Attendance attendance) {
        try{
            attendanceService.update(attendanceID, attendance);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(AttendanceNotFoundException ex){
            log.debug("attendance {} is already existed", attendanceID);
            return new ResponseEntity<>(new ApiError("attendance with id " + attendanceID + " doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
