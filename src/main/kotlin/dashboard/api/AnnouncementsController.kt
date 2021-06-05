package dashboard.api

import dashboard.exceptions.*
import dashboard.models.jpa.Announcement
import dashboard.interfaces.controllerInterfaces.AnnouncementControllerInterface
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import dashboard.services.AnnouncementService


@RestController
@RequestMapping("/api/v1/announcements")
class AnnouncementsController(val announcementService: AnnouncementService) : AnnouncementControllerInterface {

    private val LOGGER: Logger = LoggerFactory.getLogger(AnnouncementsController::class.java)

    override fun createAnnouncement(announcement: Announcement): ResponseEntity<*> {
        return try {
            announcementService.save(announcement)
            LOGGER.debug("New announcement {} is created", announcement)
            ResponseEntity<String>("New employee created", HttpStatus.CREATED)
        } catch (ex: BadRequestException) {
            ResponseEntity<ApiError>(ApiError("Announcement with id ${announcement.id} is already existed",HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST)
        } catch (ex: Exception) {
            ResponseEntity<ApiError>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun allEmployees(): ResponseEntity<*> {
        return try{
            ResponseEntity<Any>(announcementService.all(), HttpStatus.OK)
        } catch (ex: Exception){
            ResponseEntity<ApiError>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }


    override fun getEmployeeById(announcementID: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any>(announcementService.getById(announcementID), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<ApiError>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun deleteEmployeeById(announcementID: Int): ResponseEntity<*> {
        return try {
            announcementService.delete(announcementID)
            LOGGER.debug("Announcement with id {} is deleted", announcementID)
            ResponseEntity<String>("Announcement with id $announcementID is deleted", HttpStatus.OK)
        } catch (ex: AnnouncementNotFoundException) {
            ExceptionFactory.ANNOUNCEMENT_NOT_FOUND(announcementID)
        } catch (ex: Exception) {
            ResponseEntity<ApiError>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun updateEmployee(announcementID: Int, announcement: Announcement): ResponseEntity<*> {
        return try {
            announcementService.update(announcementID, announcement)
            LOGGER.debug("Announcement {} is updated", announcement)
            ResponseEntity<String>("Announcement with id $announcement is updated", HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            ExceptionFactory.ANNOUNCEMENT_NOT_FOUND(announcementID)
        } catch (ex: Exception) {
            ResponseEntity<ApiError>(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}