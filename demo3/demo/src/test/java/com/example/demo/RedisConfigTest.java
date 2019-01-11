package com.example.demo;

import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaab","111");

    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User(1L,"张三","18309225600@163.com","男");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("u1",user);
        valueOperations.set("u2",user,1000L, TimeUnit.SECONDS);
        Thread.sleep(1000L);

        boolean exists = redisTemplate.hasKey("u2");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }
}
