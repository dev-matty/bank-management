package com.mattydev.bankmanagement.exception;

/**
 * @author matty - 28/03/2023
 * @project bank-management
 */
public class UserNotFoundException extends UserException {
    public UserNotFoundException(String message){
        super(message);
    }
}
