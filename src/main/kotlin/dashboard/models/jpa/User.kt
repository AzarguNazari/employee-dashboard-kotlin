package dashboard.models.jpa

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
    val username: String,
    val password: String,
    @OneToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "employee_username", referencedColumnName = "username")
    private val employee: Employee
)