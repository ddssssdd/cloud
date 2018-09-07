package com.sfu.cloud.firstcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class FirstCloudProviderApplication {

    public static void main(String[] args) {
        //SpringApplication.run(FirstCloudProviderApplication.class, args);
        System.out.println("please input server port:");
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(FirstCloudProviderApplication.class).properties("server.port="+port).run(args);
    }
}
