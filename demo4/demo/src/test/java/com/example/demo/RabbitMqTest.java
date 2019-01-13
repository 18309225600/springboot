package com.example.demo;

import com.example.demo.service.provider.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void test(){
        helloSender.send();
    }

    @Test
    public void test1(){
        helloSender.send1();
    }

    @Test
    public void test2(){
        helloSender.send2();
    }
}
