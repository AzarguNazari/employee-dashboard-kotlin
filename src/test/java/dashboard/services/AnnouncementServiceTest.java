package dashboard.services;

import dashboard.models.jpa.Announcement;
import repositories.AnnouncementRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.AnnouncementService;

import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnnouncementServiceTest {

    @Mock
    private AnnouncementRepository announcementRepository;

    @InjectMocks
    private AnnouncementService announcementService;


//    @Test
//    void save() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void exist() {
//    }

    @Test
    void getAll() {

        Announcement announcement1 = new Announcement();
        announcement1.setId(1);
        announcement1.setCreated(Date.from(Instant.now()));
        announcement1.setText("First announcement");

        List<Announcement> announcements = Arrays.asList(announcement1);
        when(announcementRepository.findAll()).thenReturn(announcements);
        assertEquals(announcementService.getAll(), announcements);
    }

//    @Test
//    void getById() {
//    }
}