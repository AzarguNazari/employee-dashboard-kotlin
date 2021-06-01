package dashboard.models.jpa

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
class Task(
    @Id @GeneratedValue var id: Int? = 0,
    val taskname: String? = null,
    val description: String? = null,
    @Enumerated(EnumType.STRING) val priority: Priority? = Priority.NORMAL,
    val percentage: Int? = 0,
    @NotNull @Enumerated(EnumType.STRING) val status : Status? = Status.NOT_READY,
    @ManyToMany(mappedBy = "tasks") val assignedTo: Set<Employee>? = null
)