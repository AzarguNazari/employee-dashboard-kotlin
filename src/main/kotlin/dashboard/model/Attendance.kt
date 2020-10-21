package dashboard.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attendance")
class Attendance(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        @Temporal(TemporalType.DATE)
        val date: Date,
        val present: Boolean,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "employee_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator::class, property="id")
        @JsonIdentityReference(alwaysAsId=true)
        @JsonProperty("employee_id")
        val employee: Employee? = null
)