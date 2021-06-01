package dashboard.repositories

import dashboard.models.jpa.Attendance
import org.springframework.data.jpa.repository.JpaRepository

interface AttendanceRepository : JpaRepository<Attendance, Int>