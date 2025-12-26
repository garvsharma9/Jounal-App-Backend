package com.journal.journalApp.Services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private RedisTemplate redisTemplate;
    @Disabled
    @Test
    void redisBeanTest(){
//        redisTemplate.opsForValue().set("email","gmail@email.com");
        Object salary = redisTemplate.opsForValue().get("email");
        int a=1;
    }
}
