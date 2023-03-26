package com.mattydev.bankmanagement.bankmanagement.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author matty - 25/03/2023
 * @project bank-management
 */
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private BigDecimal amount;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ExpenseType type;

    public Expense() {
    }

    public Expense(User user, BigDecimal amount, Date date, ExpenseType type) {
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    // getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }
}
