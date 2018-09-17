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



    @XmlRootElement
    class Person{

        Integer personId;

        String name;

        Integer age;

        String message;

        @XmlElement
        public Integer getPersonId(){
            return personId;
        }
        public void setPersonId(Integer personId){
            this.personId =personId;
        }
        @XmlElement
        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }
        @XmlElement
        public Integer getAge(){
            return this.age;
        }

        public void setAge(Integer age){
            this.age = age;
        }
        @XmlElement
        public String getMessage(){
            return  this.message;
        }

        public void setMessage(String message){
            this.message = message;
        }

    }

    @Data
    @XmlRootElement
    class Result{
        @XmlElement
        String message;
    }
}
