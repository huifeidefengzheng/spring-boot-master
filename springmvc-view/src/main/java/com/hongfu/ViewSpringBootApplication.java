package com.hongfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hongfu.dao")
@SpringBootApplication
public class ViewSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViewSpringBootApplication.class,args);
    }
}
