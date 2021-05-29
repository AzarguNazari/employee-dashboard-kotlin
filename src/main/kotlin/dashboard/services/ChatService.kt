package dashboard.services

import dashboard.models.jpa.EmployeeDto.password1
import dashboard.models.jpa.EmployeeDto.password2
import dashboard.models.jpa.EmployeeDto.username
import dashboard.models.jpa.EmployeeDto.firstName
import dashboard.models.jpa.EmployeeDto.lastName
import dashboard.models.jpa.EmployeeDto.salary
import dashboard.models.jpa.EmployeeDto.position
import dashboard.models.jpa.Employee.id
import dashboard.models.jpa.Employee.tasks
import dashboard.repositories.AnnouncementRepository
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.models.jpa.Announcement
import dashboard.exceptions.AnnouncementNotFoundException
import lombok.extern.slf4j.Slf4j
import dashboard.models.jpa.Attendance
import org.springframework.beans.factory.annotation.Autowired
import dashboard.repositories.AttendanceRepository
import dashboard.services.AttendanceService
import dashboard.exceptions.AttendanceNotFoundException
import lombok.extern.log4j.Log4j2
import dashboard.interfaces.serviceInterfaces.ChatServiceInterface
import dashboard.interfaces.serviceInterfaces.DashboardServiceInterface
import dashboard.repositories.EmployeeRepository
import kotlin.Throws
import dashboard.exceptions.InvalidInput
import dashboard.models.jpa.EmployeeDto
import dashboard.models.jpa.Employee
import dashboard.services.DashboardService
import dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface
import dashboard.repositories.TaskRepository
import dashboard.exceptions.BadRequestException
import dashboard.exceptions.EmployeeNotFoundException
import dashboard.exceptions.TaskNotFoundException
import dashboard.interfaces.serviceInterfaces.TaskServiceInterface
import dashboard.interfaces.serviceInterfaces.UserServiceInterface
import dashboard.repositories.UserRepository
import dashboard.exceptions.UserNotFoundException
import org.springframework.stereotype.Service

@Service
@Log4j2
class ChatService : ChatServiceInterface { //    @Autowired
    //    private MessageRepository messageRepository;
    //
    //    @Override
    //    public void save(Attendance attendance) {
    //        messageRepository.save(attendance);
    //        log.debug("New attendance is added {}", attendance);
    //    }
    //
    //    @Override
    //    public void delete(Integer attendanceId) {
    //
    //    }
    //
    //    @Override
    //    public void update(Integer attendanceId, Attendance attendance) {
    //
    //    }
    //
    //    @Override
    //    public boolean exist(Integer attendanceId) {
    //        return false;
    //    }
    //
    //    @Override
    //    public List<Attendance> getAllAttendances() {
    //        return null;
    //    }
    //
    //    @Override
    //    public Attendance getAttendanceById(Integer attendanceId) {
    //        return null;
    //    }
    //
    //
    //    @Override
    //    public void delete(Integer attendanceId) {
    //        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
    //        if(byId.isEmpty()) throw new AttendanceNotFoundException();
    //        attendanceRepository.deleteById(attendanceId);
    //    }
    //
    //    @Override
    //    public void update(Integer attendanceId, Attendance attendance) {
    //        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
    //        if(byId.isEmpty()) throw new AttendanceNotFoundException();
    //        attendanceRepository.deleteById(attendanceId);
    //        attendance.setId(attendanceId);
    //        attendanceRepository.save(attendance);
    //    }
    //
    //    @Override
    //    public boolean exist(Integer attendanceId) {
    //        return attendanceRepository.findById(attendanceId).isPresent();
    //    }
    //
    //    @Override
    //    public List<Attendance> getAllAttendances() {
    //        return attendanceRepository.findAll();
    //    }
    //
    //    @Override
    //    public Attendance getAttendanceById(Integer attendanceId) {
    //        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
    //        if(byId.isEmpty()) throw new AttendanceNotFoundException();
    //        return byId.get();
    //    }
}