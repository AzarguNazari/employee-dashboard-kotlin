package dashboard.model

import javax.persistence.*


@Entity
@Table(name = "employee")
class Employee(
        @Id @GeneratedValue
        var id: Int = 0,
        var firstname: String,
        var lastname: String,
        var username: String,
        var password: String,
        var salary: Int,

        @Enumerated(EnumType.STRING)
        var title: Title = Title.NOT_DEFINED,

        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        @JoinTable(name = "task_assign", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "task_id")])
        var tasks: Set<Task> = mutableSetOf(),

        @OneToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "employee_roles", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
        val roles: Set<Role> = mutableSetOf(),

        @OneToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "message_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "message_id")])
        val messages: Set<Message> = mutableSetOf(),

        @OneToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "attendance_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "attendance_id")])
        val attendance: Set<Message> = mutableSetOf(),

        @OneToOne(mappedBy = "employee")
        val user: User? = null
)
