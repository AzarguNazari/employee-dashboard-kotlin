package com.employeeDashboard.service

import com.employeeDashboard.Attendance
import com.employeeDashboard.repository.AttendanceRepository
import org.springframework.stereotype.Service

@Service
class AttendanceService(val attendanceRepository: AttendanceRepository) : DAO<Attendance> {
    override fun save(t: Attendance) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, t: Attendance) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Attendance> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Attendance {
        TODO("Not yet implemented")
    }
}