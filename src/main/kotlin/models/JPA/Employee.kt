package models.JPA

import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(@Id @GeneratedValue var id: Int,
                    var firstname: String,
                    var lastname: String,
                    var username: String,
                    var password: String,
                    var salary: Int,
                    @Enumerated(EnumType.STRING) var title: Title,
                    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
                    @JoinTable(name = "task_assign", joinColumns = [JoinColumn(name = "employee_id")],  inverseJoinColumns = [JoinColumn(name = "task_id")])
                    var tasks: Set<Task>,
                    @OneToMany(fetch = FetchType.EAGER)
                    @JoinTable(name = "employee_roles", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
                    private var roles: Set<Role>,
                    @OneToMany(fetch = FetchType.EAGER)
                    @JoinTable(
                        name = "message_employee",
                        joinColumns = [JoinColumn(name = "employee_id")],
                        inverseJoinColumns = [JoinColumn(name = "message_id")]
                    )
                    private val messages: Set<Message>,
                    @OneToMany(fetch = FetchType.EAGER)
                    @JoinTable(name = "attendance_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "attendance_id")])
                    private val attendance: Set<Message>,
                    @OneToOne(mappedBy = "employee")
                    private val user: User,

                    ) {
}