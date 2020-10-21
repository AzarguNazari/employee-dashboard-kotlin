package dashboard.services

import dashboard.exception.AttendanceNotFoundException
import dashboard.models.Attendance
import dashboard.repositories.AttendanceRepository
import org.springframework.stereotype.Service

@Service
class AttendanceService(val attendanceRepository: AttendanceRepository) : DAO<Attendance> {
    override fun save(attendence: Attendance) {
        attendanceRepository.save(attendence)
    }

    override fun delete(id: Int) {
        attendanceRepository.deleteById(id)
    }

    override fun update(id: Int, attendence: Attendance) {
        if(exist(id)){
            attendence.id = id
            attendanceRepository.deleteById(id)
            attendanceRepository.save(attendence)
        }
        throw AttendanceNotFoundException()
    }

    override fun getAll() = attendanceRepository.findAll().toList()

    override fun getById(id: Int) = attendanceRepository.findById(id)?.get()

    override fun exist(id: Int) = attendanceRepository.existsById(id)
}
