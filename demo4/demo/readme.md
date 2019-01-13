learn：springboot中使用rocketMQ

1.添加pom依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>

2.配置文件中添加配置
    spring.rabbitmq.host=192.168.0.86
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=admin
    spring.rabbitmq.password=123456


3.队列配置
    @Configuration
    public class RabbitConfig {
        @Bean
        public Queue Queue() {
            return new Queue("hello");
        }

    }


4.provider：
    public class HelloSender {
        @Autowired
        private AmqpTemplate rabbitTemplate;

        public void send() {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("hello", context);
        }

    }

5.test
