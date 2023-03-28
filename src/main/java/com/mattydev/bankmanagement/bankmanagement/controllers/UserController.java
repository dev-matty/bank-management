package com.mattydev.bankmanagement.bankmanagement.controllers;

import com.mattydev.bankmanagement.bankmanagement.exception.UserMailPresentException;
import com.mattydev.bankmanagement.bankmanagement.exception.UserNotFoundException;
import com.mattydev.bankmanagement.bankmanagement.models.User;
import com.mattydev.bankmanagement.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author matty - 26/03/2023
 * @project bank-management
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}
    //GET USER BY ID
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id){
        try {
            return new ResponseEntity<User>(userService.findUserById(id),HttpStatus.OK);
        } catch (UserNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());
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
            return new ResponseEntity<User>(userService.createUser(user),HttpStatus.OK);
        } catch (UserMailPresentException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,exception.getLocalizedMessage());
        }
    }


}
