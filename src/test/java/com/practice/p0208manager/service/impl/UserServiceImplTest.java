package com.practice.p0208manager.service.impl;

import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.mapper.UserMapper;
import com.practice.p0208manager.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class UserServiceImplTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin_ValidCredentials_Success() {
        // Arrange
        String userName = "ww";
        String password = "55";
        User user = new User();
        user.setUserName(userName);
        user.setPassword(DigestUtils.md5Hex(password));
        when(userMapper.getUserByUserName(userName)).thenReturn(user);
        // Act
        User loggedInUser = userService.login(userName, password);

        // Assert
        assertNotNull(loggedInUser);
        assertEquals(userName, loggedInUser.getUserName());
        assertEquals(DigestUtils.md5Hex(password), loggedInUser.getPassword());
    }

    @Test
    public void testLogin_EmptyUsername_ExceptionThrown() {
        // Arrange
        String userName = "";
        String password = "55";

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.login(userName, password));
    }

    @Test
    public void testLogin_EmptyPassword_ExceptionThrown() {
        // Arrange
        String userName = "ww";
        String password = "";

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.login(userName, password));
    }

    @Test
    public void testLogin_UserNotFound_ExceptionThrown() {
        // Arrange
        String userName = "w";
        String password = "55";
        when(userMapper.getUserByUserName("userName")).thenReturn(null);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.login(userName, password));
    }

    @Test
    public void testLogin_IncorrectPassword_ExceptionThrown() {
        // Arrange
        String userName = "ww";
        String password = "5";
        User user = new User();
        user.setUserName(userName);
        user.setPassword(DigestUtils.md5Hex("55"));
        when(userMapper.getUserByUserName(userName)).thenReturn(user);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.login(userName, password));
    }
}