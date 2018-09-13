package com.sfu.cloud.cloudinvoker.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule implements IRule {
    private ILoadBalancer ib;

    @Override
    public Server choose(Object o) {
        List<Server> servers = ib.getAllServers();
        System.out.println("this is customer load balance rule");
        for(Server server: servers){
            System.out.println("               "+ server.getHostPort());
        }
        return servers.get(1);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        ib = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return ib;
    }
}

