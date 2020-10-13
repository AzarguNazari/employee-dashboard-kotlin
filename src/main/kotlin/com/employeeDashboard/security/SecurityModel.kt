package com.employeeDashboard.security

import com.employeeDashboard.Employee
import com.employeeDashboard.Role
import java.util.function.Function
import java.util.stream.Collectors

//
//class CustomEmployeeDetails(employee: Employee?) : Employee(employee), UserDetails {
//    val authorities: Collection<Any?>
//        get() {
//            println(roles.size)
//            return roles
//                    .stream()
//                    .map(Function<Role, Any> { role: Role -> SimpleGrantedAuthority("ROLE_" + role.role) })
//                    .collect(Collectors.toList<Any>())
//        }
//    override var password: String
//        get() = super.password
//        set(password) {
//            super.password = password
//        }
//    override var username: String
//        get() = super.username
//        set(username) {
//            super.username = username
//        }
//    val isAccountNonExpired: Boolean
//        get() = true
//    val isAccountNonLocked: Boolean
//        get() = true
//    val isCredentialsNonExpired: Boolean
//        get() = true
//    val isEnabled: Boolean
//        get() = true
//}