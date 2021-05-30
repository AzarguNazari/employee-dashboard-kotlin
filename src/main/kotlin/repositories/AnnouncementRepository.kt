package repositories

import dashboard.models.jpa.Announcement
import org.springframework.data.jpa.repository.JpaRepository

interface AnnouncementRepository : JpaRepository<Announcement?, Int?>