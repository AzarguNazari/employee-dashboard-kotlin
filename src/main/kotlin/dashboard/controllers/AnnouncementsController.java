package dashboard.controllers;

import dashboard.interfaces.controllerInterfaces.AnnouncementControllerInterface;
import dashboard.exceptions.*;
import dashboard.models.jpa.Announcement;
import dashboard.services.AnnouncementService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementsController implements AnnouncementControllerInterface {

    @Autowired
    private AnnouncementService announcementService;

    @Override
    public ResponseEntity<?> createAnnouncement(Announcement announcement) {
        try{
            announcementService.save(announcement);
            log.debug("New announcement {} is created", announcement);
            return new ResponseEntity<>("New employee created", HttpStatus.CREATED);
        }
        catch(BadRequestException ex){
            return new ResponseEntity<>(new ApiError("Announcement with id " + announcement.getId() + " is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllEmployees() {
        try{
            return new ResponseEntity<>(announcementService.getAll(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeById(Integer announcementID) {
        try{
            return new ResponseEntity<>(announcementService.getById(announcementID), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer announcementID) {
        try{
            announcementService.delete(announcementID);
            log.debug("Announcement with id {} is deleted", announcementID);
            return new ResponseEntity<>("Announcement with id " + announcementID + " is deleted", HttpStatus.OK);
        }
        catch(AnnouncementNotFoundException ex){
            return ExceptionFactory.ANNOUNCEMENT_NOT_FOUND(announcementID);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer announcementID, Announcement announcement) {
        try{
            announcementService.update(announcementID, announcement);
            log.debug("Announcement {} is updated", announcement);
            return new ResponseEntity<>("Announcement with id " + announcement + " is updated", HttpStatus.OK);
        }
        catch(AttendanceNotFoundException ex){
            return ExceptionFactory.ANNOUNCEMENT_NOT_FOUND(announcementID);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
