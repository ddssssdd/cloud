package com.sfu.cloud;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class PersonMain {
    public static void main(String[] args){
        PersonClient client = Feign.builder().decoder(new GsonDecoder())
                .target(PersonClient.class,"http://localhost:8080/");
        PersonClient.Person person = client.findById(2);
        System.out.println(person);


        person.personId = 100;
        PersonClient updateService = Feign.builder().encoder(new GsonEncoder())
                .target(PersonClient.class,"http://localhost:8080/");

        String result = updateService.createPerson(person);
        System.out.println(result);
    }
}
