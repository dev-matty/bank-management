package com.mattydev.bankmanagement.bankmanagement.exception;

/**
 * @author matty - 28/03/2023
 * @project bank-management
 */
public abstract class UserException extends RuntimeException {
    public UserException(String message){super(message);}
}
