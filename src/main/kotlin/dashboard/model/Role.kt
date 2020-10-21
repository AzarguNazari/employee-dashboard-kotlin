package dashboard.model

import javax.persistence.*

@Entity
@Table(name = "role")
class Role(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        val role: String,

        @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE], mappedBy = "roles")
        val employees: Set<Employee> = mutableSetOf()
)
