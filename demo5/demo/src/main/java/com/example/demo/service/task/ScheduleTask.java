package com.example.demo.service.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ScheduleTask {

    @PostConstruct
    public void init(){
        System.out.println("===========task start");
    }

    @Scheduled(cron = "*/6 * * * * ?")
    public void process1(){
        System.out.println("this is scheduler task runing ");
    }

    @Scheduled(fixedRate = 6000)
    public void process2(){
        System.out.println("this is scheduler task2 runing ");
    }
}
