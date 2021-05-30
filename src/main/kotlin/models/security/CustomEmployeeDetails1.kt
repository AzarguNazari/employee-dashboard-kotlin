//package models.security
//
//import dashboard.models.jpa.Employee.id
//import models.JPA.Employee.id
//import dashboard.models.jpa.Announcement.id
//import exceptions.ExceptionFactory.ANNOUNCEMENT_NOT_FOUND
//import org.springframework.validation.annotation.Validated
//import lombok.experimental.FieldDefaults
//import lombok.AccessLevel
//import lombok.NoArgsConstructor
//import javax.persistence.GeneratedValue
//import javax.persistence.GenerationType
//import lombok.RequiredArgsConstructor
//import javax.persistence.Enumerated
//import javax.persistence.ManyToMany
//import javax.persistence.JoinColumn
//import javax.persistence.TemporalType
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import java.util.stream.Collectors
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.beans.factory.annotation.Autowired
//import security.CustomEmployeeDetailsService
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import kotlin.Throws
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import repositories.EmployeeRepository
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import lombok.extern.log4j.Log4j2
//import lombok.extern.slf4j.Slf4j
//import services.AttendanceService
//import com.fasterxml.jackson.annotation.JsonTypeInfo
//import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver
//import org.springframework.http.HttpStatus
//import com.fasterxml.jackson.annotation.JsonFormat
//import java.time.LocalDateTime
//import exceptions.ApiValidationError
//import org.springframework.validation.FieldError
//import org.springframework.validation.ObjectError
//import java.lang.RuntimeException
//import org.springframework.http.ResponseEntity
//import lombok.EqualsAndHashCode
//import lombok.AllArgsConstructor
//import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.DeleteMapping
//import org.springframework.web.bind.annotation.PutMapping
//import org.springframework.web.bind.annotation.RestController
//import org.springframework.web.bind.annotation.RequestMapping
//import controllers.AnnouncementsController
//import models.JPA.Employee
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.security.core.context.SecurityContextHolder
//
//class CustomEmployeeDetails(employee: Employee?) : Employee(employee), UserDetails {
//    override fun getAuthorities(): Collection<GrantedAuthority?> {
//        System.out.println(getRoles().size())
//        return getRoles()
//            .stream()
//            .map { role -> SimpleGrantedAuthority("ROLE_" + role.getRole()) }
//            .collect(Collectors.toList())
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return true
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isEnabled(): Boolean {
//        return true
//    }
//}