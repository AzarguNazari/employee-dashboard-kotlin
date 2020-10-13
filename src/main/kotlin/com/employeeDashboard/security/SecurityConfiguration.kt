//package com.employeeDashboard.security
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import kotlin.Throws
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//    @Autowired
//    private val customEmployeeDetails: CustomEmployeeDetailsService? = null
//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val user: UserDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build()
//        return InMemoryUserDetailsManager(user)
//    }
//
//    @Throws(Exception::class)
//    protected fun configure(http: HttpSecurity) {
////        http.headers().frameOptions().disable();
//        http.csrf().disable()
//        http
//                .authorizeRequests()
//                .antMatchers("/signin", "/signout").permitAll()
//                .anyRequest().authenticated()
//    }
//}