
package com.spring.gemfire.client.resource;

import com.spring.gemfire.client.entity.Person;
import com.spring.gemfire.client.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personService.findPersonById(id);
    }
}
