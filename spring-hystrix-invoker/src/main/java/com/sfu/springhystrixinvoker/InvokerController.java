package com.sfu.springhystrixinvoker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvokerController {
    @Autowired
    private PersonService personService;

    @GetMapping("/router/{personId}")
    public PersonService.Person router(@PathVariable Integer personId){
        PersonService.Person p = personService.getPerson(personId);
        return p;
    }
}
