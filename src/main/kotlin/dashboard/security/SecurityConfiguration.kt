package dashboard.security

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke

@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http {
            httpBasic {}
            headers { frameOptions { disable() } }
            csrf { disable() }
            authorizeRequests {
//                authorize("/auth/**", hasAuthority("ROLE_ADMIN"))
                authorize("/**", permitAll)
            }
        }
    }
}
