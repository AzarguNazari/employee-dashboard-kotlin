package dashboard.services

import dashboard.exceptions.AnnouncementNotFoundException
import dashboard.interfaces.serviceInterfaces.CrudOperations
import dashboard.models.jpa.Announcement
import dashboard.repositories.AnnouncementRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementService(val announcementRepository: AnnouncementRepository) : CrudOperations<Announcement?> {

    override fun save(announcement: Announcement) = announcementRepository.save(announcement)

    override fun delete(announcementId: Int) {
        val byId = announcementRepository.findById(announcementId)
        if (byId.isEmpty) throw AnnouncementNotFoundException()
        announcementRepository.deleteById(announcementId)
    }

    override fun update(announcementId: Int, announcement: Announcement) {
        if (exist(announcementId)) {
            delete(announcementId)
            announcement.setId(announcementId)
            announcementRepository.save(announcement)
        } else throw AnnouncementNotFoundException()
    }

    override fun exist(announcementId: Int): Boolean {
        return announcementRepository.findById(announcementId).isPresent
    }

    override fun getById(announcementId: Int): Announcement {
        return announcementRepository.findById(announcementId).orElseThrow { AnnouncementNotFoundException() }
    }

    override fun update(id: Int, `object`: Announcement?) {
        TODO("Not yet implemented")
    }

    override fun all(): List<Announcement?>? {
        TODO("Not yet implemented")
    }

    override fun save(announcement: Announcement?) = announcementRepository.save(announcement)
}