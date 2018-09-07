package com.sfu.cloud.firstcloudprovider;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request){
        Person person  = new Person(personId,"Michael Scofield",30);
        person.setMessage(request.getRequestURL().toString());
        return person;
    }

    static boolean canVisit=false;
    @RequestMapping("/change")
    public String change(){
        canVisit = !canVisit;
        return canVisit?"can":"can't";
    }

}
class Person{
    private Integer personId;
    private String name;
    private Integer age;
    private String message;
    public Person(Integer personId,String name,Integer age){
        this.personId = personId;
        this.name = name;
        this.age = age;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

