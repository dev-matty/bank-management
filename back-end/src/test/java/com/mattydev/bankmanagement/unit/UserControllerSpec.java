package com.mattydev.bankmanagement.unit;

import com.mattydev.bankmanagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author matty - 31/05/2023
 * @project back-end
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerSpec {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/bank/v1/user/1")).andExpect(status().isOk());
    }
    @Test
    public void testGetUserExpenses() throws  Exception {
        mockMvc.perform(get("/bank/v1/user/1/expenses")).andExpect(status().isOk());
    }
    @Test
    public void testGetUserExpenseWithDate() throws  Exception {
        String startDate = "2022-01-01";
        String endDate = "2023-05-01";
        mockMvc.perform(
                get("/bank/v1/user/1/expenses")
                    .param("startDate", String.valueOf(startDate)))
                .andExpect(status()
                        .isOk());
        mockMvc.perform(get("/bank/v1/user/1/expense")
                .param("startDate", String.valueOf(startDate))
                .param("endDate", String.valueOf(endDate))
                ).andExpect(status().isOk());
    }
}
