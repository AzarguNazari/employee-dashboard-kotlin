package services

import exceptions.AttendanceNotFoundException
import interfaces.serviceInterfaces.CrudOperations
import models.jpa.Attendance
import org.springframework.stereotype.Service
import repositories.AttendanceRepository
import java.util.*

@Service

class AttendanceService(val attendanceRepository: AttendanceRepository) : CrudOperations<Attendance> {

    override fun save(attendance: Attendance) {
        attendanceRepository.save(attendance)
//        AttendanceService.log.debug("New attendance is added {}", attendance)
    }

    override fun delete(attendanceId: Int) {
        val byId: Optional<Attendance> = attendanceRepository.findById(attendanceId)
        if (byId.isEmpty) throw AttendanceNotFoundException()
        attendanceRepository.deleteById(attendanceId)
    }

    override fun update(attendanceId: Int, attendance: Attendance) {
        val byId: Optional<Attendance> = attendanceRepository.findById(attendanceId)
        if (byId.isEmpty) throw AttendanceNotFoundException()
        attendanceRepository.deleteById(attendanceId)
        attendance.id = attendanceId
        attendanceRepository.save(attendance)
    }

    override fun exist(attendanceId: Int): Boolean {
        return attendanceRepository.findById(attendanceId).isPresent
    }

    override fun all(): List<Attendance> = attendanceRepository.findAll()

    override fun getById(attendanceId: Int): Attendance {
        val byId: Optional<Attendance> = attendanceRepository.findById(attendanceId)
        if (byId.isEmpty) throw AttendanceNotFoundException()
        return byId.get()
    }
}