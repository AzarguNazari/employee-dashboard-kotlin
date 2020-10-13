package com.employeeDashboard.service


import com.employeeDashboard.Announcement
import com.employeeDashboard.repository.AnnouncementRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementService(val announcementRepository: AnnouncementRepository) : DAO<Announcement> {
    override fun save(t: Announcement) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, t: Announcement) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Announcement> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Announcement {
        TODO("Not yet implemented")
    }

}