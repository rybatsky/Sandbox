package com.testpay.sandbox;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
@EnableJpaRepositories("com.testpay.sandbox.model")
public class SandboxApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SandboxApplication.class, args);
    }
}
