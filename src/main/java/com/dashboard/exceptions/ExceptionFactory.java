package com.dashboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionFactory {

    public static ResponseEntity<?> EMPLOYEE_NOT_FOUND(Integer employeeID){
        return new ResponseEntity<>(new ApiError("Employee with ID " + employeeID + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> TASK_NOT_FOUND(Integer taskID){
        return new ResponseEntity<>(new ApiError("Task with ID " + taskID + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> INTERNAL_EXCEPTION(){
        return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<?> ATTENDANCE_NOT_FOUND(Integer attendanceID){
        return new ResponseEntity<>(new ApiError("Attendance with ID " + attendanceID + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> ANNOUNCEMENT_NOT_FOUND(Integer announcementID){
        return new ResponseEntity<>(new ApiError("Announcement with ID " + announcementID + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
