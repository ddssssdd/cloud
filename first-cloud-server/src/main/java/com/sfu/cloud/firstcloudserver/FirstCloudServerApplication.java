package com.sfu.cloud.firstcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer
public class FirstCloudServerApplication {

    public static void main(String[] args) {
        System.out.println("Please input profile name to start:");
        Scanner scanner = new Scanner(System.in);
        String profiles = scanner.nextLine();

        //SpringApplication.run(FirstCloudServerApplication.class, args);
        new SpringApplicationBuilder(FirstCloudServerApplication.class).profiles(profiles).run(args);
    }
}
