package com.mattydev.bankmanagement.bankmanagement.controllers;

import com.mattydev.bankmanagement.bankmanagement.models.User;
import com.mattydev.bankmanagement.bankmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author matty - 26/03/2023
 * @project bank-management
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("{id}")
    public Optional<User> getUserById (@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping
    public User getUserByEmail(@RequestParam("email") String email){
        System.out.println(email);
        User user = repository.findByEmail(email).iterator().next();
        return user;
    }

    @PostMapping
    public User createUser(User user) throws Exception {
       // if(getUserByEmail(user.getEmail()) != null){
            return repository.save(user);
        //}
        //throw new Exception();
    }


}
