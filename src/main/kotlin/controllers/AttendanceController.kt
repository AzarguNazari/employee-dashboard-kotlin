package controllers;//package dashboard.controllers;
//
//import dashboard.exceptions.*;
//import dashboard.interfaces.controllerInterfaces.AttendanceControllerInterface;
//import dashboard.models.JPA.Attendance;
//import dashboard.services.AttendanceService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Log4j2
//@RestController
//@RequestMapping("/api/v1/attendance")
//public class AttendanceController implements AttendanceControllerInterface {
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @Override
//    public ResponseEntity<?> createAttendance(Attendance attendance) {
//        try{
//            attendanceService.save(attendance);
//            log.debug("New attendance {} is created", attendance);
//            return new ResponseEntity<>("New attendance created", HttpStatus.CREATED);
//        }
//        catch(BadRequestException ex){
//            return new ResponseEntity<>(new ApiError("Attendance with id " + attendance.getId() + " is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getAllAttendances(Pageable pageable) {
//        try{
//            return new ResponseEntity<>(attendanceService.getAll(), HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getAttendanceById(Integer attendanceID) {
//        try{
//            return new ResponseEntity<>(attendanceService.getById(attendanceID), HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> deleteAttendanceById(Integer attendanceID) {
//        try{
//            attendanceService.delete(attendanceID);
//            log.debug("attendanceID with id {} is deleted", attendanceID);
//            return new ResponseEntity<>("Attendance with id " + attendanceID + " is deleted", HttpStatus.OK);
//        }
//        catch(AttendanceNotFoundException ex){
//            return ExceptionFactory.ATTENDANCE_NOT_FOUND(attendanceID);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> updateAttendance(Integer attendanceID, Attendance attendance) {
//        try{
//            attendanceService.update(attendanceID, attendance);
//            log.debug("Attendance {} is updated", attendance);
//            return new ResponseEntity<>("Attendance with id " + attendanceID + " is updated", HttpStatus.OK);
//        }
//        catch(AttendanceNotFoundException ex){
//            return ExceptionFactory.ATTENDANCE_NOT_FOUND(attendanceID);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
