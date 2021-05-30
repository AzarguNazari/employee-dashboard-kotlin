package models.jpa

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "message")
data class Message(
    @Column val message: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
    @Temporal(TemporalType.DATE) val created: Date)