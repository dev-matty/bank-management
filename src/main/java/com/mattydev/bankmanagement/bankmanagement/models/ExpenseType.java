package com.mattydev.bankmanagement.bankmanagement.models;

import jakarta.persistence.*;

/**
 * @author matty - 25/03/2023
 * @project bank-management
 */
@Entity
@Table(name = "expense_types")
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public ExpenseType() {
    }

    public ExpenseType(String name) {
        this.name = name;
    }

    // getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
