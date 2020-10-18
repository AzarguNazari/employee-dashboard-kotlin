package dashboard.service


import dashboard.exception.AnnouncementNotFoundException
import dashboard.model.Announcement
import dashboard.repository.AnnouncementRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementService(val announcementRepository: AnnouncementRepository) : DAO<Announcement> {

    override fun save(announcement: Announcement) {
        announcementRepository.save(announcement)
    }

    override fun delete(id: Int) {
        announcementRepository.deleteById(id)
    }

    override fun update(id: Int, announcement: Announcement) {
        if(exist(id)){
            announcement.id = id
            announcementRepository.deleteById(id)
            announcementRepository.save(announcement)
        }
        throw AnnouncementNotFoundException()
    }

    override fun getAll() = announcementRepository.findAll().toList()

    override fun getById(id: Int) = announcementRepository.findById(id)?.get()

    override fun exist(id: Int) = announcementRepository.existsById(id)
}
