package models.JPA

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attendance")
data class Attendance(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
                      val present: Boolean,
                      @Temporal(TemporalType.DATE) val date: Date)