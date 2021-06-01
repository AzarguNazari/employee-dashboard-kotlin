package dashboard.util

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User

object UserUtils {
    val authenticatedUserName: String?
        get() {
            val auth = SecurityContextHolder.getContext()
                .authentication
            return if (auth != null) (auth.principal as User).username else null
        }
}