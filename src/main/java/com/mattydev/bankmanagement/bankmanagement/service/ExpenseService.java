package com.mattydev.bankmanagement.bankmanagement.service;

import com.mattydev.bankmanagement.bankmanagement.models.Expense;

import java.util.List;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
public interface ExpenseService {
    List<Expense> listExpense();
    List<Expense> findExpensesByUser(Long idUser);
    Expense findExpenseById(Long idExpense);
    Expense createExpense(Expense expense);
    Expense updateExpense(Expense expense);
    boolean deleteExpense(Long idExpense);
}
