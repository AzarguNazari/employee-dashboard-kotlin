package dashboard.models.jpa

import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
    @Id @GeneratedValue var id: Int? = 0,
    var firstname: String? = null,
    var lastname: String? = null,
    var username: String? = null,
    var password: String? = null,
    var salary: Int? = 0,
    @Enumerated(EnumType.STRING) var title: Title? = null,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(name = "task_assign", joinColumns = [JoinColumn(name = "employee_id")],  inverseJoinColumns = [JoinColumn(name = "task_id")])
    var tasks: Set<Task>? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    private var roles: Set<Role>? = null,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "message_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "message_id")])
    private val messages: Set<Message>? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "attendance_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "attendance_id")])
    private val attendance: Set<Message>? = null,
    @OneToOne(mappedBy = "employee")
    private val user: User? = null,
)