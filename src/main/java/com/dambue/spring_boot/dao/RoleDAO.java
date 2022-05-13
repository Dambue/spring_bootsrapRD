package com.dambue.spring_boot.dao;

import com.dambue.spring_boot.model.Role;

import java.util.Set;

public interface RoleDAO {
    Set<Role> findRolesById(Long[] ids);
}
