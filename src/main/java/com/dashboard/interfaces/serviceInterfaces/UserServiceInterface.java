package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.models.JPA.User;

import java.util.List;

public interface UserServiceInterface {
    void save(User user);
    void delete(Integer userId);
    void update(Integer userId, User user);
    boolean exist(Integer userId);
    List<User> getAllUsers();
    User getUserById(Integer userId);
}
