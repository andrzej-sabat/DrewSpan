package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
    Set<Role> findRoleById(int id);
}
