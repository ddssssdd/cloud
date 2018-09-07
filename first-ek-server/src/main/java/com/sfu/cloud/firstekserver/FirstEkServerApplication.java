package com.sfu.cloud.firstekserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FirstEkServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstEkServerApplication.class, args);
    }
}
