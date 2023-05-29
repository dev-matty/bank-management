package com.mattydev.bankmanagement.controllers;

import com.mattydev.bankmanagement.exception.ExpenseException;
import com.mattydev.bankmanagement.exception.UserException;
import com.mattydev.bankmanagement.exception.UserMailPresentException;
import com.mattydev.bankmanagement.exception.UserNotFoundException;
import com.mattydev.bankmanagement.models.Expense;
import com.mattydev.bankmanagement.models.User;
import com.mattydev.bankmanagement.service.ExpenseService;
import com.mattydev.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author matty - 26/03/2023
 * @project bank-management
 */
@RestController
@RequestMapping("/bank/v1/user")
public class UserController {

    private UserService userService;
    private ExpenseService expenseService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @Autowired
    public void setExpenseService(ExpenseService expenseService){this.expenseService = expenseService;}

    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id){
        try {
            return new ResponseEntity<User>(userService.findUserById(id),HttpStatus.OK);
        } catch (UserNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());
        }
    }
    @GetMapping("/{id}/expenses")
    public ResponseEntity<List<Expense>> getExpenseByUserId(@PathVariable Long id){
        try {
            return new ResponseEntity<List<Expense>>(expenseService.findExpensesByUser(id),HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,exception.getLocalizedMessage());
        }
    }
    @GetMapping("/{id}/expense")
    public  ResponseEntity<List<Expense>> getExpensesById(@PathVariable("id") Long userId,
        @RequestParam("startDate" ) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> endDate){
        try {
            return new ResponseEntity<List<Expense>>(expenseService.findExpensesByUserAndDate(userId,startDate,endDate),HttpStatus.OK);
        } catch (ExpenseException exception){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,exception.getLocalizedMessage());
        }
    }

    //GET USER BY MAIL
    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email){
        try {
            return  new ResponseEntity<User>(userService.findUserByEmail(email),HttpStatus.OK);
        } catch (UserNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());
        }
    }

    //CREATE USER AND TEST IF MAIL IS NOT OK
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws Exception {
        try {
            return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED     );
        } catch (UserMailPresentException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) throws Exception {
        try {
            return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
        } catch(UserException exception){
            throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id){
        try {
            return new ResponseEntity<Boolean>(userService.deleteUser(id),HttpStatus.OK);
        } catch (UserNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }
}
