package dashboard.repositories

import dashboard.models.jpa.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Int>