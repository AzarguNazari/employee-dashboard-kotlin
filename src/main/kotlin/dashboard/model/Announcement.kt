package dashboard.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "announcement")
class Announcement(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int,
        val text: String,
        @Temporal(TemporalType.DATE)
        val created: Date
)
