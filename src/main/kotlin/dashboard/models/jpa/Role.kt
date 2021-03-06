package dashboard.models.jpa

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    val roleId: Int,

    @Column(name = "role_name")
    val role: String
)