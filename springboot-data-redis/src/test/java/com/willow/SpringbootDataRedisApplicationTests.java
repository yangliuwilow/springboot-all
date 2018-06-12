package com.willow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        System.out.println("###########"+stringRedisTemplate.opsForValue().get("msg"));
    }


    @Test
    public void test() {
        redisTemplate.opsForValue().set("my_redis","abc",1000);
        redisTemplate.opsForValue().get("my_redis");

    }

}
