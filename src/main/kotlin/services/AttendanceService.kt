package services

import com.dashboard.repositories.AttendanceRepository
import interfaces.serviceInterfaces.CrudOperations
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
class AttendanceService : CrudOperations<Attendance> {
    @Autowired
    private val attendanceRepository: AttendanceRepository? = null
    override fun save(attendance: Attendance) {
        attendanceRepository.save(attendance)
        AttendanceService.log.debug("New attendance is added {}", attendance)
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
        attendance.setId(attendanceId)
        attendanceRepository.save(attendance)
    }

    override fun exist(attendanceId: Int): Boolean {
        return attendanceRepository.findById(attendanceId).isPresent()
    }

    override val all: List<T>
        get() = attendanceRepository.findAll()

    override fun getById(attendanceId: Int): Attendance {
        val byId: Optional<Attendance> = attendanceRepository.findById(attendanceId)
        if (byId.isEmpty) throw AttendanceNotFoundException()
        return byId.get()
    }
}