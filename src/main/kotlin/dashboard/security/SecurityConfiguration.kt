package security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfiguration(/*val customEmployeeDetails: CustomEmployeeDetailsService*/) : WebSecurityConfigurerAdapter() {

    @Bean
    public override fun userDetailsService(): UserDetailsService {
        val user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
//        http.headers().frameOptions().disable();
        http
            .authorizeRequests()
            .antMatchers("/signin", "/signout", "/swagger-ui.html", "/api/**", "/swagger-ui/**", "/v3/dashboard.api-docs/**")
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
    }
}