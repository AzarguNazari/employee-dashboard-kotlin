//package com.employeeDashboard.security
//
//import com.dashboard.exception.EmployeeNotFoundException
//import com.dashboard.model.Employee
//import com.dashboard.model.security.CustomEmployeeDetails
//import com.dashboard.repository.EmployeeRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.stereotype.Service
//import java.util.*
//import kotlin.Throws
//
//@Service
//class CustomEmployeeDetailsService : UserDetailsService {
//    @Autowired
//    private val employeeRepository: EmployeeRepository? = null
//    @Throws(UsernameNotFoundException::class)
//    fun loadUserByUsername(username: String?): UserDetails {
//        val employee: Optional<Employee> = employeeRepository.findByUsername(username)
//        employee.orElseThrow<RuntimeException> { EmployeeNotFoundException() }
//        return employee.map<Any> { CustomEmployeeDetails() }.get()
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
//        val savedEntity: Employee = employeeRepository.save(employee)
//        return savedEntity.getId()
//    }
//
//    fun findUserByUsername(userName: String?): Employee {
//        return employeeRepository.findByUsername(userName).orElse(null)
//    }
//}