package dashboard.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "message")
class Message(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        val message: String,
        @Temporal(TemporalType.DATE)
        val created: Date
)