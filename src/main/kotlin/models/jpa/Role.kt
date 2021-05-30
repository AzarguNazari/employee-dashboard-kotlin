package models.jpa

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
    @Column(name = "role_name") val role: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id") val roleId: Int
)