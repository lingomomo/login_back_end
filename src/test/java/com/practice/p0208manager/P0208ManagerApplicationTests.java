package com.practice.p0208manager;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P0208ManagerApplicationTests {

    @Test
    void contextLoads() {
        String password = "55";
        String s = DigestUtils.md5Hex(password);
        System.out.println(s);
    }

}
