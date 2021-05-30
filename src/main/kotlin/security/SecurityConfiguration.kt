//package security
//
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import kotlin.Throws
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.core.userdetails.User
//import java.lang.Exception
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//    @Autowired
//    private val customEmployeeDetails: CustomEmployeeDetailsService? = null
//    @Bean
//    public override fun userDetailsService(): UserDetailsService {
//        val user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("password")
//            .roles("USER")
//            .build()
//        return InMemoryUserDetailsManager(user)
//    }
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
////        http.headers().frameOptions().disable();
//        http
//            .authorizeRequests()
//            .antMatchers("/signin", "/signout", "/swagger-ui.html", "/api/**", "/swagger-ui/**", "/v3/api-docs/**")
//            .permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .csrf().disable()
//    }
//}