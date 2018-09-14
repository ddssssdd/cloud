package com.sfu.cloud.client;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;


import javax.ws.rs.core.Response;
import java.io.InputStream;

public class CxfClient {
    public static void main(String[] args) throws Exception{
        WebClient client = WebClient.create("http://localhost:8080/person/1");
        Response response = client.get();
        InputStream inputStream = (InputStream)response.getEntity();
        String content = IOUtils.readStringFromStream(inputStream);
        System.out.println(content);


    }
}
