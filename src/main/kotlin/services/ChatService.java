package services;

import interfaces.serviceInterfaces.ChatServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ChatService implements ChatServiceInterface {

//    @Autowired
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
