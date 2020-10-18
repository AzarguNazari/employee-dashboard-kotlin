package dashboard.model

import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.GenerationType.AUTO


@Entity
@Table(name = "user")
class User(
        @Id @GeneratedValue(strategy = AUTO)
        var id: Int = 0,
        var username: String,
        var password: String,
        @OneToOne(cascade = [ALL])
        @JoinColumn(name = "employee_id", referencedColumnName = "id")
        val employee: Employee? = null
)

enum class Title { DEVELOPER, MANAGER, HR, NOT_DEFINED }

enum class Status { DONE, READY, NOT_READY }

enum class RoleType { ADMIN, USER }

enum class Priority { LOW, NORMAL, HIGH }

class EmployeeDto(
        val firstName: String,
        val lastName: String,
        val username: String,
        val email: String,
        val password1: String,
        val password2: String,
        val salary: Int,
        val position: String
)
