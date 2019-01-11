learn：web相关功能介绍

1.json接口开发   @RestController 里面包含了@ResponseBody
  如果需要页面开发，需要改成@Controller

2.自定义Filter
    a.实现javax.servlet.Filter接口，重写方法
    b.添加@Configeration注解

3.自定义配置Properties 或者yml
    使用@Value("${com.no.a}")获取

4.log建议使用logback

5.数据库操作： 以mysql、spring-data-jpa为例
    a.添加依赖
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
            </dependency>
             <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
            </dependency>
    b.添加配置
        spring:
          datasource:
            url:  jdbc:mysql://localhost:3306/test
            driverClass:  com.mysql.jdbc.Driver
            username: root
            password: 123456
          jpa:
            properties:
              hibernate:
                hbm2ddl:
                  auto: update
                dialect:  org.hibernate.dialect.MySQL5InnoDBDialect
            show-sql:  true

6.thymeleaf 模板
    springboot建议使用thymeleaf模板代替jsp

7.WebJars 的使用


