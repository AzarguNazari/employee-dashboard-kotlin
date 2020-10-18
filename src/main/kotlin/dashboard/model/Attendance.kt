package dashboard.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attendance")
class Attendance(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        @Temporal(TemporalType.DATE)
        val date: Date,
        val present: Boolean
)