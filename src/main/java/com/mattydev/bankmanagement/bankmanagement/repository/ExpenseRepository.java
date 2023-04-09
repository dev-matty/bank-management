package com.mattydev.bankmanagement.bankmanagement.repository;

import com.mattydev.bankmanagement.bankmanagement.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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

    @Query(value = "SELECT * FROM EXPENSES where user_id = ?1 AND date between ?2 and ?3",nativeQuery = true)
    List<Expense>findExpensesByUserAndDate(Long user_id, LocalDate startDate, LocalDate endDate);
    @Query(value = "SELECT * FROM EXPENSES where user_id = ?1 AND date >= ?2",nativeQuery = true)
    List<Expense>findExpensesByUserAndDate(Long user_id, LocalDate startDate);

}
