package com.sfu.cloud;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public interface PersonClient {

    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")
    String createPerson(Person person);


    @RequestLine("POST /person/createXML")
    @Headers("Content-Type: application/xml")
    Result createPersonXML(Person person);


    @Data
    @XmlRootElement
    class Person{
        @XmlElement
        Integer personId;
        @XmlElement
        String name;
        @XmlElement
        Integer age;
        @XmlElement
        String message;
    }

    @Data
    @XmlRootElement
    class Result{
        @XmlElement
        String message;
    }
}
