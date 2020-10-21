package dashboard.model

import javax.persistence.*
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.persistence.FetchType.EAGER
import javax.persistence.FetchType.LAZY


@Entity
@Table(name = "employee")
class Employee(
        @Id @GeneratedValue
        var id: Int = 0,
        var firstname: String,
        var lastname: String,
        var salary: Int,

        @Enumerated(EnumType.STRING)
        var title: Title = Title.NOT_DEFINED,

        @ManyToMany(fetch = LAZY, cascade = [PERSIST, MERGE])
        @JoinTable(name = "employee_tasks",
                joinColumns = [JoinColumn(name = "employee_id") ],
                inverseJoinColumns = [ JoinColumn(name = "task_id") ])
        var tasks: Set<Task> = mutableSetOf(),


        @ManyToMany(fetch = LAZY, cascade = [PERSIST, MERGE])
        @JoinTable(name = "employee_roles",
                joinColumns = [JoinColumn(name = "employee_id") ],
                inverseJoinColumns = [ JoinColumn(name = "role_id") ])
        var roles: Set<Role> = mutableSetOf(),

        @OneToOne(fetch = LAZY, optional = false)
        @JoinColumn(name = "user_id")
        var user: User? = null
)
