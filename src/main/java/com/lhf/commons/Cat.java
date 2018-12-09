package com.lhf.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Cat {

    @Autowired
    private Environment env;

    public String get(String propertyName){
        return env.getProperty(propertyName);
    }
}
