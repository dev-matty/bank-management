package com.mattydev.bankmanagement.bankmanagement.repository;

import com.mattydev.bankmanagement.bankmanagement.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query(value = "SELECT * FROM expenses where user_id = ?1",nativeQuery = true)
    List<Expense> findExpensesWithUser(Long userId);

    @Override
    @Query(value = "SELECT * FROM expenses where id = ?1",nativeQuery = true)
    Optional<Expense> findById(Long id);
}
