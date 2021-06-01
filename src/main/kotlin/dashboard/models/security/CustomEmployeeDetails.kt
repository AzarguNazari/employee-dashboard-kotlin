//package dashboard.models.security
//
//import dashboard.Employee
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import java.util.stream.Collectors
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