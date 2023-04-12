package com.mattydev.bankmanagement.bankmanagement.service;

import com.mattydev.bankmanagement.bankmanagement.models.Expense;
import com.mattydev.bankmanagement.bankmanagement.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
