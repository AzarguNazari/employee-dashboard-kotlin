package dashboard.services

import dashboard.exceptions.AnnouncementNotFoundException
import dashboard.models.jpa.Announcement
import dashboard.interfaces.serviceInterfaces.CrudOperations
import org.springframework.stereotype.Service
import dashboard.repositories.AnnouncementRepository
import java.util.*

@Service
class AnnouncementService(val announcementRepository: AnnouncementRepository) : CrudOperations<Announcement> {

    override fun save(announcement: Announcement) {
        announcementRepository.save(announcement)
    }

    override fun delete(announcementId: Int) {
        val byId: Optional<Announcement> = announcementRepository.findById(announcementId)
        if (byId.isEmpty) throw AnnouncementNotFoundException()
        announcementRepository.deleteById(announcementId)
    }

    override fun update(announcementId: Int, announcement: Announcement) {
        if (exist(announcementId)) {
            delete(announcementId)
            announcement.id = announcementId
            announcementRepository.save(announcement)
        } else throw AnnouncementNotFoundException()
    }

    override fun exist(announcementId: Int) = announcementRepository.findById(announcementId).isPresent


    override fun all(): List<Announcement> = announcementRepository.findAll()

    override fun getById(announcementId: Int): Announcement = announcementRepository.findById(announcementId).orElseThrow { AnnouncementNotFoundException() }

}