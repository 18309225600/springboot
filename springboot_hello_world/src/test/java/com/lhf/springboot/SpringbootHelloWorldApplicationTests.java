package com.lhf.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootHelloWorldApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootHelloWorldApplicationTests {

    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUrl() throws MalformedURLException {
        this.url = new URL("http://127.0.0.1:"+port+"/");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(Objects.toString(url), String.class);
        String body = responseEntity.getBody();
        Assert.assertEquals(body,"Springboot Hello World");
    }

}
