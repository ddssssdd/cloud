package com.sfu.cloud.firstcloudprovider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;


@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (HomeController.canVisit){
            return new Health.Builder(Status.UP).build();
        }else{
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
