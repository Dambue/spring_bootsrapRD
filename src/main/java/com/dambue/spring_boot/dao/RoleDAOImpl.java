package com.dambue.spring_boot.dao;

import com.dambue.spring_boot.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> findRolesById(Long[] ids) {
        return (Set<Role>) entityManager
                .createQuery("select r from Role r where r.id in (:ids)")
                .setParameter("ids", Arrays.asList(ids))
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
