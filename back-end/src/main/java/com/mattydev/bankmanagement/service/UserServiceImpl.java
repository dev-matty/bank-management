package com.mattydev.bankmanagement.service;

import com.mattydev.bankmanagement.exception.UserMailPresentException;
import com.mattydev.bankmanagement.exception.UserNotFoundException;
import com.mattydev.bankmanagement.models.User;
import com.mattydev.bankmanagement.repository.UserRepository;
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
            throw new UserNotFoundException("User not found with this email : "+email);
    }

    public boolean isEmailIsInDb(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    @Override
    public User createUser(User user) {
        if(isEmailIsInDb(user.getEmail())){
            throw new UserMailPresentException("User with this mail already in DB : " +user.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user){
        if(findUserById(user.getId()) != null){
            User userFind = findUserById(user.getId());
            //If email is modify and new email is in db throw error
            if(!userFind.getEmail().equals(user.getEmail())
                    && isEmailIsInDb(user.getEmail())){
                throw new UserMailPresentException("Another user with this mail is already in DB : " +user.getEmail());
            } else {
                return userRepository.save(user);
            }
        } else {
            throw new UserNotFoundException("User not found with this ID : "+user.getId());
        }
    }

    @Override
    public boolean deleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return userRepository.findById(id).isPresent();
        } else {
            throw new UserNotFoundException("User cannot be delete is not found with ID : "+id);
        }
    }


}
