package com.dambue.spring_boot.service;

import com.dambue.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersWithRoles();
    void save(User user, Long[] roles);
    void delete(Long id);
    User getUserById(Long id);
    void update(Long id, User updUser, Long[] roles);
}

