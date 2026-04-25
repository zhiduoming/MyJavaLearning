package com.github.zhiduoming.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisTestController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/redis/ping")
    public String ping() {
        stringRedisTemplate.opsForValue().set("Tlias:test", "hello redis");
        return stringRedisTemplate.opsForValue().get("Tlias:test");
    }
}
