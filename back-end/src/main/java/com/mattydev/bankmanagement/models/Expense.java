package com.mattydev.bankmanagement.models;

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
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;


    private BigDecimal amount;

    private Date date;

    @Column(name = "type_id", nullable = false)
    private Long type_id;

    public Expense() {
    }

    public Expense(Long user_id, BigDecimal amount, Date date, Long type) {
        this.user_id = user_id;
        this.amount = amount;
        this.date = date;
        this.type_id = type;
    }

    // getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUserId(Long user) {
        this.user_id = user;
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

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public boolean hasAmountMoreThanZero() {
        return getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
}
