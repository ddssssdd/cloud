package com.sfu.cloud.firstekserviceinvoker;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestRest {

    @Test
    public void invoke6times() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for(int i=0;i<6;i++){
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
}
