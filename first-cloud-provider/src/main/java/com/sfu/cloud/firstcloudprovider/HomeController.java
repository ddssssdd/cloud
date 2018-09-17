package com.sfu.cloud.firstcloudprovider;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Thread.sleep;

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

    @RequestMapping("/hello")
    public String hello(){
        return "hello, world";
    }

    @RequestMapping(value = "/person/create",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody Person person){
        System.out.println(person);
        return "Success, Person Id:"+ person.getPersonId();
    }

    @RequestMapping(value = "/person/createXML",method = RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE,
    produces = MediaType.APPLICATION_XML_VALUE)
    public String createPersonXML(@RequestBody Person person){
        System.out.println(person);
        person.setName(person.getName()+"-XML");
        return "<result><message>success</message></result>";
    }


    @GetMapping("/normalHello")
    public String normalHello(HttpServletRequest request){
        return "hello, this is a normal world.";
    }

    @GetMapping("/errorHello")
    public String errorHello(HttpServletRequest request) throws Exception{
        sleep(10000);
        return "Error Hello world";
    }

}
class Person{
    private Integer personId;
    private String name;
    private Integer age;
    private String message;
    public Person(){

    }
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

