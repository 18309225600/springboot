learn：从0开始搭建springboot

1：从start.spring.io中下载一个最简单的springboot应用
2.pom文件中加入web的依赖
3.导入idea中，创建 controller（hellowroldController）控制层  service  业务逻辑层   domian  持久层和实体类
4.启动服务，浏览器中输入 127.0.0.1:8080/hello  就可以看到效果了



单元测试：
    使用mockMvc进行单元测试

    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest
    public class HelloWorldTest {

        private MockMvc mockMvc;

        @Before
        public void setUp() throws Exception {
            mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        }

        @Test
        public void getTest() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        }
    }