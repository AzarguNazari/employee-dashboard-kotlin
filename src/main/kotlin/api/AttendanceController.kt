package api

import exceptions.ApiError
import exceptions.AttendanceNotFoundException
import exceptions.BadRequestException
import exceptions.ExceptionFactory
import interfaces.controllerInterfaces.AttendanceControllerInterface
import models.jpa.Attendance
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import services.AttendanceService

@RestController
@RequestMapping("/api/v1/attendance")
class AttendanceController(val attendanceService: AttendanceService) : AttendanceControllerInterface {

    override fun createAttendance(attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.save(attendance)
//            AttendanceController.log.debug("New attendance {} is created", attendance)
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
//            AttendanceController.log.debug("attendanceID with id {} is deleted", attendanceID)
            ResponseEntity("Attendance with id $attendanceID is deleted", HttpStatus.OK)
        } catch (ex: AttendanceNotFoundException) {
            ExceptionFactory.ATTENDANCE_NOT_FOUND(attendanceID)
        } catch (ex: Exception) {
            ResponseEntity(
                ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    override fun updateAttendance(attendanceID: Int, attendance: Attendance): ResponseEntity<*> {
        return try {
            attendanceService.update(attendanceID, attendance)
//            AttendanceController.log.debug("Attendance {} is updated", attendance)
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