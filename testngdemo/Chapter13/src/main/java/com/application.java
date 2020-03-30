package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableScheduling
public class application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        SpringApplication.run(application.class, args);
    }

    //预摧毁
    @PreDestroy
    public void close() {

        application.context.close();
    }
}
