learn：springboot中使用redis

1.引入redis依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>

2.添加配置
    # REDIS (RedisProperties)
    # Redis数据库索引（默认为0）
    spring.redis.database=0
    # Redis服务器地址
    spring.redis.host=192.168.0.58
    # Redis服务器连接端口
    spring.redis.port=6379
    # Redis服务器连接密码（默认为空）
    spring.redis.password=
    # 连接池最大连接数（使用负值表示没有限制）
    spring.redis.pool.max-active=8
    # 连接池最大阻塞等待时间（使用负值表示没有限制）
    spring.redis.pool.max-wait=-1
    # 连接池中的最大空闲连接
    spring.redis.pool.max-idle=8
    # 连接池中的最小空闲连接
    spring.redis.pool.min-idle=0
    # 连接超时时间（毫秒）
    spring.redis.timeout=0


3.添加cache配置类
    @Configuration
    @EnableCaching
    public class RedisConfig extends CachingConfigurerSupport {

        @Bean
        public KeyGenerator keyGenerator(){
            return new KeyGenerator() {
                @Override
                public Object generate(Object targetClass, Method method, Object... params) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(targetClass.getClass().getName());
                    sb.append(method.getName());
                    for (Object param : params) {
                        sb.append(param.toString());
                    }
                    return sb.toString();
                }
            };
        }


        @Bean
        public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
            StringRedisTemplate template = new StringRedisTemplate(factory);
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
            template.afterPropertiesSet();
            return template;
        }


    }

4.共享session

    a.引入依赖
        <dependency>
            <groupId>org.springframework.session</groupId>
            <artifactId>spring-session-data-redis</artifactId>
        </dependency>

    b.Session配置
        @Configuration
        @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
        public class SessionConfig {
        }



