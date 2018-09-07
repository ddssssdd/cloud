package com.sfu.cloud.firstcloudprovider;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;

public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator indicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status s = indicator.health().getStatus();
        if (s.equals(Status.UP)){
            return InstanceInfo.InstanceStatus.UP;
        }else{
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
