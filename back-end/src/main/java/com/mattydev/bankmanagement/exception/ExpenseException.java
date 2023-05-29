package com.mattydev.bankmanagement.exception;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
public abstract class ExpenseException extends RuntimeException{
    public ExpenseException(String message){
        super(message);
    }
}
