package com.mattydev.bankmanagement.repository;

import com.mattydev.bankmanagement.models.Expense;
import com.mattydev.bankmanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author matty - 26/03/2023
 * @project bank-management
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM USERS where email = ?1",nativeQuery = true)
    Optional<User> findByEmail(String emailValue);

    @Query(value = "SELECT * FROM EXPENSES where user_id = ?1",nativeQuery = true)
    List<Expense> findExpensesByUser(Long user_id);
}
