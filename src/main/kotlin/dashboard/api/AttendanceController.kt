package dashboard.api

import dashboard.exceptions.ApiError
import dashboard.exceptions.AttendanceNotFoundException
import dashboard.exceptions.BadRequestException
import dashboard.exceptions.ExceptionFactory
import dashboard.interfaces.controllerInterfaces.AttendanceControllerInterface
import dashboard.models.jpa.Attendance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import dashboard.services.AttendanceService


@RestController
@RequestMapping("/dashboard/api/v1/attendance")
class AttendanceController(val attendanceService: AttendanceService) : AttendanceControllerInterface {

    private val LOGGER: Logger = LoggerFactory.getLogger(AttendanceController::class.java)

    override fun createAttendance(attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.save(attendance)
            LOGGER.debug("New attendance {} is created", attendance)
            ResponseEntity("New attendance created", HttpStatus.CREATED)
        } catch (ex: BadRequestException) {
            ResponseEntity(
                ApiError(
                    "Attendance with id ${attendance.id} is already existed",
                    HttpStatus.BAD_REQUEST
                ), HttpStatus.BAD_REQUEST
            )
        } catch (ex: Exception) {
            ResponseEntity(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun getAllAttendances(pageable: Pageable): ResponseEntity<*> {
        return try {
            ResponseEntity(attendanceService.all(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun getAttendanceById(attendanceID: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Attendance>(attendanceService.getById(attendanceID), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun deleteAttendanceById(attendanceID: Int): ResponseEntity<*> {
        return try {
            attendanceService.delete(attendanceID)
            LOGGER.debug("attendanceID with id {} is deleted", attendanceID)
            ResponseEntity("Attendance with id $attendanceID is deleted", HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            ExceptionFactory.ATTENDANCE_NOT_FOUND(attendanceID)
        } catch (ex: Exception) {
            ResponseEntity(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateAttendance(attendanceID: Int, attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.update(attendanceID, attendance)
            LOGGER.debug("Attendance {} is updated", attendance)
            ResponseEntity("Attendance with id $attendanceID is updated", HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            ExceptionFactory.ATTENDANCE_NOT_FOUND(attendanceID)
        } catch (ex: Exception) {
            ResponseEntity(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}