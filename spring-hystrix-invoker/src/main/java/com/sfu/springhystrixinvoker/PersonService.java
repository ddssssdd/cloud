package com.sfu.springhystrixinvoker;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPersonFallback")
    public Person getPerson(Integer id){
        Person p = restTemplate.getForObject("http://cloud-provider/person/{personId}",Person.class,id);
        return p;
    }

    public Person getPersonFallback(Integer id){
        Person p = new Person(id,"fallback",-30);
        p.setMessage("this is hystrix fallback return");
        return p;
    }

    static class Person{
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
}
