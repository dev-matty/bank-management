package com.mattydev.bankmanagement.controllers;

import com.mattydev.bankmanagement.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author matty - 28/03/2023
 * @project bank-management
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws  Exception{
        assertThat(controller).isNotNull();
    }
    @Test
    public void createUser() throws Exception {
        User user = new User("Joe","d","johndoe@example.com","ok");
        //assertThat(controller.create(user)).isNull();
    }
}
