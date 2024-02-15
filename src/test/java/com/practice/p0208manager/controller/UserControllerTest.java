package com.practice.p0208manager.controller;

import com.practice.p0208manager.P0208ManagerApplication;
import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController) .build();
    }

    @Test
    public void testLogin_ValidCredentials_Success() throws Exception {
        // Arrange
        String userName = "ww";
        String password = "55";
        User user = new User();
        user.setUserName(userName);
        user.setPassword(DigestUtils.md5Hex(password));
        when(userService.login(userName, password)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                        .param("userName", userName)
                        .param("password", password))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}