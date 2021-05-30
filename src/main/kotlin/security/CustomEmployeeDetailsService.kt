//package security
//
//import dashboard.exceptions.EmployeeNotFoundException
//import dashboard.models.jpa.Employee
//import dashboard.models.security.CustomEmployeeDetails
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.stereotype.Service
//import java.util.*
//
//@Service
//class CustomEmployeeDetailsService : UserDetailsService {
//    @Autowired
//    private val employeeRepository: EmployeeRepository? = null
//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(username: String): UserDetails {
//        val employee: Optional<Employee> = employeeRepository.findByUsername(username)
//        employee.orElseThrow { EmployeeNotFoundException() }
//        return employee.map<Any> { (id, firstname, lastname, username1, password, salary, title, tasks, roles, messages, attendance, user) -> CustomEmployeeDetails() }
//            .get()
//    }
//}
//
//internal class UserService {
//    @Autowired
//    var passwordEncoder: PasswordEncoder? = null
//
//    @Autowired
//    var employeeRepository: EmployeeRepository? = null
//    fun saveUser(employee: Employee?): Long {
//        val (id) = employeeRepository.save<Employee>(employee)
//        return id
//    }
//
//    fun findUserByUsername(userName: String?): Employee {
//        return employeeRepository.findByUsername(userName).orElse(null)
//    }
//}