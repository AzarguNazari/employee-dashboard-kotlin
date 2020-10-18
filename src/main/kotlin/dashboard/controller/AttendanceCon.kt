package dashboard.controller


import dashboard.controller.interfaces.AttendanceControllerInterface
import dashboard.exception.ApiError
import dashboard.exception.AttendanceNotFoundException
import dashboard.model.Attendance
import dashboard.service.AttendanceService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/attendance")
@Tag(name = "Attendance")
class AttendanceController(val attendanceService: AttendanceService) : AttendanceControllerInterface {

    val logger: Logger = LoggerFactory.getLogger(AttendanceController::class.java)

    override fun createAttendance(attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.save(attendance)
            logger.debug("New task {} is added", attendance)
            ResponseEntity("New attendance is added", HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getAllAttendances(): ResponseEntity<*> {
        return try {
            ResponseEntity(attendanceService.getAll(), HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity<Any>(ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun getAttendanceById(attendanceID: Int): ResponseEntity<*> {
        return try {
            ResponseEntity<Any?>(attendanceService.getById(attendanceID), HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            logger.debug("attendance {} is already existed", attendanceID)
            ResponseEntity<Any>(ApiError("attendance with id $attendanceID doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun deleteAttendanceById(attendanceID: Int): ResponseEntity<*> {
        return try {
            attendanceService.delete(attendanceID)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            logger.debug("attendance {} is already existed", attendanceID)
            ResponseEntity<Any>(ApiError("attendance with id $attendanceID doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override fun updateAttendance(attendanceID: Int, attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.update(attendanceID, attendance)
            ResponseEntity<Any>(HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            logger.debug("attendance {} is already existed", attendanceID)
            ResponseEntity<Any>(ApiError("attendance with id $attendanceID doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
        } catch (ex: Exception) {
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}