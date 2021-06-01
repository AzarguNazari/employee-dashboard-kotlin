package dashboard.repositories

import dashboard.models.jpa.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, Int>