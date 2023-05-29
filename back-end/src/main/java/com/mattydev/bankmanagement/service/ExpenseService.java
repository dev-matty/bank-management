package com.mattydev.bankmanagement.service;

import com.mattydev.bankmanagement.models.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
public interface ExpenseService {
    List<Expense> listExpense();
    Expense findExpenseById(Long idExpense);
    Expense createExpense(Expense expense);
    Expense updateExpense(Expense expense);
    boolean deleteExpense(Long idExpense);
    List<Expense> findExpensesByUser(Long id);
    List<Expense> findExpensesByUserAndDate(Long id, LocalDate startDate, Optional<LocalDate> endDate);

}
