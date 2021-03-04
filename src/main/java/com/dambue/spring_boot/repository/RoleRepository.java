package com.dambue.spring_boot.repository;

import com.dambue.spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    //@Query("SELECT a FROM Role a JOIN FETCH a.users")
    Role findRoleById(Long id);
}
