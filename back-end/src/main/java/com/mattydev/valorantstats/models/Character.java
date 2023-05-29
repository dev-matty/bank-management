package com.mattydev.valorantstats.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author matty - 29/05/2023
 * @project back-end
 */
@Entity
@Table(name = "valorant_characters")
public class Character {
    private int id;
    private String name;
    private String role;
    private String description;

    // Constructeur par défaut
    public Character() {
    }

    // Constructeur avec paramètres
    public Character(int id, String name, String role, String description) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.description = description;
    }

    // Getters et setters
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}