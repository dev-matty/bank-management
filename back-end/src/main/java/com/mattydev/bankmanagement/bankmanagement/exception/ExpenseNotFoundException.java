package com.mattydev.bankmanagement.bankmanagement.exception;

/**
 * @author matty - 08/04/2023
 * @project bank-management
 */
public class ExpenseNotFoundException extends ExpenseException{
    public ExpenseNotFoundException(String message){
        super(message);
    }
}
