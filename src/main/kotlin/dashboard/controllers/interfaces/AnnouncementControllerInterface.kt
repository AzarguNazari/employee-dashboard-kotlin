package dashboard.controllers.interfaces

import dashboard.models.Announcement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface AnnouncementControllerInterface {

    @PostMapping
    fun createAnnouncement(@RequestBody announcement: Announcement): ResponseEntity<*>?

    @GetMapping
    fun getAllEmployees(): ResponseEntity<*>?

    @GetMapping("/{announcementID}")
    fun getEmployeeById(@PathVariable announcementID: Int): ResponseEntity<*>?

    @DeleteMapping("/{announcementID}")
    fun deleteEmployeeById(@PathVariable announcementID: Int?): ResponseEntity<*>?

    @PutMapping("/{announcementID}")
    fun updateEmployee(@PathVariable announcementID: Int?, @RequestBody announcement: Announcement?): ResponseEntity<*>?
}