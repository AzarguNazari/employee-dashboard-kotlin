package models.jpa

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attendance")
data class Attendance(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int = 0,
    val present: Boolean,
    @Temporal(TemporalType.DATE) val date: Date
)