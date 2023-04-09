package com.mattydev.bankmanagement.bankmanagement.controllers;

import com.mattydev.bankmanagement.bankmanagement.exception.ExpenseException;
import com.mattydev.bankmanagement.bankmanagement.models.Expense;
import com.mattydev.bankmanagement.bankmanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        try {
            return  new ResponseEntity<Expense>(expenseService.findExpenseById(id), HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Expense>> getExpenseByUserId(@PathVariable Long id){
        try {
            return new ResponseEntity<List<Expense>>(expenseService.findExpensesByUser(id),HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,exception.getLocalizedMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        try {
            return new ResponseEntity<Expense>(expenseService.createExpense(expense),HttpStatus.CREATED);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        try {
            return new ResponseEntity<Expense>(expenseService.updateExpense(expense),HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        try {
            if(expenseService.deleteExpense(id)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Intern error");
            }
            return new ResponseEntity<String>("Delete expense successfull",HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage(),exception);
        }
    }
}
