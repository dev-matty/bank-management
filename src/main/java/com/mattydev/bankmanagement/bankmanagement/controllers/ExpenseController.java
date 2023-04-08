package com.mattydev.bankmanagement.bankmanagement.controllers;

import com.mattydev.bankmanagement.bankmanagement.models.Expense;
import com.mattydev.bankmanagement.bankmanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    private ExpenseService expenseService;

    @Autowired
    private void setExpenseService(ExpenseService expenseService) { this.expenseService = expenseService;}

    @GetMapping("/@id")
    public ResponseEntity<Expense> getExpenseById(Long id){
        try {
            return  new ResponseEntity<Expense>(expenseService.findExpenseById(id), HttpStatus.OK);
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());
        }
    }

}
