package com.sfu.cloud.cloudinvoker.rule;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("Customer Ping, server port:" + server.getHostPort());
        return true;
    }
}