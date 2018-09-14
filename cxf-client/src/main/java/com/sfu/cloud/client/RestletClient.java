package com.sfu.cloud.client;


import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.util.HashMap;
import java.util.Map;

public class RestletClient {
    public static void main(String[] args) throws Exception{
        ClientResource client = new ClientResource("http://localhost:8080/person/1");

        Representation response = client.get(MediaType.APPLICATION_ALL_JSON);
        JacksonRepresentation jr = new JacksonRepresentation(response, HashMap.class);
        Map result = (HashMap)jr.getObject();

        System.out.println(result);
    }
}
