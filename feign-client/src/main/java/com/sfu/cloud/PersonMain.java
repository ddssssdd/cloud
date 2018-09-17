package com.sfu.cloud;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;


import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;


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


        person.personId = 200;
        feign.jaxb.JAXBContextFactory jaxbContextFactory = new feign.jaxb.JAXBContextFactory.Builder().build();

        PersonClient updateXmlService = Feign.builder().encoder(new JAXBEncoder(jaxbContextFactory))
                .decoder(new JAXBDecoder(jaxbContextFactory))
                .target(PersonClient.class,"http://localhost:8080/");
        PersonClient.Result resultXml = updateXmlService.createPersonXML(person);
        System.out.println(resultXml);
    }
}
