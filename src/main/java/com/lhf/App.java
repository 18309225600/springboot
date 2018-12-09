package com.lhf;


import com.lhf.commons.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App {

    public static void  main(String[] args){
        SpringApplication application = new SpringApplication(App.class);
        ConfigurableApplicationContext context = application.run(args);

        String ip = context.getEnvironment().getProperty("local.ip");
        System.out.println(ip);

        String appName = context.getBean(Cat.class).get("app.name");
        System.out.println(appName);
//        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);


    }
}
