package com.dashboard.repositories;

import com.dashboard.models.JPA.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
