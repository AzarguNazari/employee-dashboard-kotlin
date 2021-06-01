package dashboard.interfaces.serviceInterfaces

import dashboard.models.jpa.Attendance

interface AttendanceServiceInterface {
    fun save(attendance: Attendance?)
    fun delete(attendanceId: Int?)
    fun update(attendanceId: Int?, attendance: Attendance?)
    fun exist(attendanceId: Int?): Boolean
    val allAttendances: List<Attendance?>?
    fun getAttendanceById(attendanceId: Int?): Attendance?
}