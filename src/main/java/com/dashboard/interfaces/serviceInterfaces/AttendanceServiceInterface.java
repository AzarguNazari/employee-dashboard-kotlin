package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.models.JPA.Attendance;

import java.util.List;

public interface AttendanceServiceInterface {
    void save(Attendance attendance);
    void delete(Integer attendanceId);
    void update(Integer attendanceId, Attendance attendance);
    boolean exist(Integer attendanceId);
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Integer attendanceId);
}
