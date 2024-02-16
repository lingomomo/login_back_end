package com.practice.p0208manager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(userController);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterEach
    void closeMocks() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("userController_正常系")
    void testLogin_ValidCredentials_Success() throws Exception {
        // 模拟用户输入的数据
        String userName = "ww";
        String password = "55";
        User user = new User();
        user.setUserName(userName);
        user.setPassword(DigestUtils.md5Hex(password));
        // 使用 JSON 序列化库将对象转换为 JSON 格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(user);
        //指定mock动作
        when(userService.login(userName, password)).thenReturn(user);
        // 模拟 HTTP 请求
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/user/login")
                        .content(jsonContent)//用于接收post请求的内容
                        .contentType(MediaType.APPLICATION_JSON_VALUE);

        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        System.out.println("=======================>"+actual);
        //把actual里面的code值取出来断言
        // 使用 ObjectMapper 解析 JSON 字符串
        JsonNode jsonNode = objectMapper.readTree(actual);
        // 获取 code 字段的值
        int codeValue = jsonNode.get("code").asInt();
        assertEquals(200, codeValue);

        //不测试content-type
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
//                        .param("userName", userName)
//                        .param("password", password))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("userController_異常系")
    void testLogin_ValidCredentials_Fail() throws Exception {
        // 模拟用户输入的数据
        String userName = "ww";
        String password = "5";
        User user = new User();
        user.setUserName(userName);
        user.setPassword(DigestUtils.md5Hex(password));
        // 使用 JSON 序列化库将对象转换为 JSON 格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(user);
        //指定mock动作
        when(userService.login(userName, password)).thenReturn(null);
        // 模拟 HTTP 请求
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/user/login")
                        .content(jsonContent)//用于接收post请求的内容
                        .contentType(MediaType.APPLICATION_JSON_VALUE);

        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        //把actual里面的code值取出来断言
        // 使用 ObjectMapper 解析 JSON 字符串
        JsonNode jsonNode = objectMapper.readTree(actual);
        // 获取 code 字段的值
        int codeValue = jsonNode.get("code").asInt();
        assertEquals(200, codeValue);
    }
}