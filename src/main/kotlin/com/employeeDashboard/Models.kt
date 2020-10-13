package com.employeeDashboard

import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.FetchType.EAGER
import javax.persistence.GenerationType.AUTO
import javax.persistence.TemporalType.DATE


@Entity
@Table(name = "user")
class User(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Int = 0,
        val username: String,
        val password: String,
        @OneToOne(cascade = [ALL])
        @JoinColumn(name = "employee_username", referencedColumnName = "username")
        val employee: Employee? = null
)

enum class Title {
    DEVELOPER, MANAGER, HR
}

@Entity
@Table(name = "task")
class Task(
    @Id @GeneratedValue val id: Int = 0,
    val taskname: String,
    val description: String,
    @Enumerated(EnumType.STRING)
    val priority: Priority? = null,
    val percentage: Double,
    @Enumerated(EnumType.STRING)
    val status: Status = Status.NOT_READY,
    @ManyToMany(mappedBy = "tasks")
    val assignedTo: Set<Employee>? = null
)

enum class Status {
    DONE, READY, NOT_READY
}
enum class RoleType {
    ADMIN, USER
}

@Entity
@Table(name = "role")
class Role(
    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "role_id")
    val roleId: Int,
    @Column(name = "role_name") val role: String
)

enum class Priority {
    LOW, NORMAL, HIGH
}


@Entity
@Table(name = "message")
class Message(
    @Id @GeneratedValue(strategy = AUTO)
    val id: Int = 0,
    val message: String,
    @Temporal(DATE)
    val created: Date
)


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
    var title: Title,
    @ManyToMany(cascade = [ALL], fetch = EAGER)
    @JoinTable(name = "task_assign", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "task_id")])
    var tasks: Set<Task>,

    @OneToMany(fetch = EAGER)
    @JoinTable(name = "employee_roles", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    val roles: Set<Role>,

    @OneToMany(fetch = EAGER)
    @JoinTable(name = "message_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "message_id")])
    val messages: Set<Message>,

    @OneToMany(fetch = EAGER)
    @JoinTable(name = "attendance_employee", joinColumns = [JoinColumn(name = "employee_id")], inverseJoinColumns = [JoinColumn(name = "attendance_id")])
    val attendance: Set<Message>,

    @OneToOne(mappedBy = "employee")
    val user: User
)

@Entity
@Table(name = "attendance")
class Attendance(
    @Id @GeneratedValue(strategy = AUTO)
    val id: Int = 0,
    @Temporal(DATE)
    val date: Date,
    val present: Boolean
)


@Entity
@Table(name = "announcement")
class Announcement(
    @Id @GeneratedValue(strategy = AUTO)
    val id: Int,
    val text: String,
    @Temporal(DATE)
    val created: Date
)
