package com.mattydev.bankmanagement.service;

import com.mattydev.bankmanagement.models.User;

import java.util.List;

/**
 * @author matty - 28/03/2023
 * @project bank-management
 */
public interface UserService {
    List<User> listUser();
    User findUserById(Long id);
    User findUserByEmail(String email);
    User createUser(User user);
    User updateUser(User user);
    boolean deleteUser(Long id);
}
