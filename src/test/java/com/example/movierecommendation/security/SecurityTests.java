package com.example.movierecommendation.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessUnsecuredResource_shouldReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void accessSecuredResource_withUser_shouldReturnOk() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void loginWithValidUser_shouldSucceedWith200() throws Exception{
        mockMvc.perform(get("/login")
                .with(SecurityMockMvcRequestPostProcessors.user("user").password("password")))
                .andExpect(status().isOk());
    }

    @Test
    public void loginWithInvalidUser_shouldFailWith401() throws Exception {
        mockMvc.perform(get("/login")
                        .with(SecurityMockMvcRequestPostProcessors.user("invalid").password("invalid")))
                .andExpect(status().isUnauthorized());
    }

}
