package dashboard.models

import javax.persistence.*

@Entity
@Table(name = "task")
class Task(

        @Id @GeneratedValue var id: Int = 0,

        val taskname: String,

        val description: String,

        @Enumerated(EnumType.STRING)
        var priority: Priority = Priority.NORMAL,

        var percentage: Double = 0.0,

        @Enumerated(EnumType.STRING)
        val status: Status = Status.NOT_READY,

        @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE], mappedBy = "tasks")
        val assignedTo: Set<Employee> = mutableSetOf()
)

//private @LastModifiedDate LocalDateTime lastModifiedDate;
