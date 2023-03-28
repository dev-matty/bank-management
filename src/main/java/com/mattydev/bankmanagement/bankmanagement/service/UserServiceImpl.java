package com.mattydev.bankmanagement.bankmanagement.service;

import com.mattydev.bankmanagement.bankmanagement.exception.UserMailPresentException;
import com.mattydev.bankmanagement.bankmanagement.exception.UserNotFoundException;
import com.mattydev.bankmanagement.bankmanagement.models.User;
import com.mattydev.bankmanagement.bankmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author matty - 28/03/2023
 * @project bank-management
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException("User not found with this ID : "+id);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException("User not found with this ID : "+email);
    }

    @Override
    public User createUser(User user) {
        if(findUserByEmail(user.getEmail()) != null){
            throw new UserMailPresentException("User with this mail already in DB : " +user.getEmail());
        }
        return userRepository.save(user);
    }
}
