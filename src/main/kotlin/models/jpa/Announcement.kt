package dashboard.models.jpa

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "announcement")
data class Announcement(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
                        @Column val text: String,
                        @Column @Temporal(TemporalType.DATE) val created: Date)