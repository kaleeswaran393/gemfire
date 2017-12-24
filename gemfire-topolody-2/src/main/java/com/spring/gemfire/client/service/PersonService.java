/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.gemfire.client.service;

import com.spring.gemfire.client.service.AddressService;
import com.spring.gemfire.client.entity.Person;
import com.spring.gemfire.client.gateway.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepo;
    
    @Autowired
    private AddressService  addressService;
    
    public Person createPerson(Person person){
        person = personRepo.save(person);
        person.setAddress(addressService.getAddress(1L));
       return person;
    }
    
    public Person findPersonById(Long id){
        Person person = personRepo.findById(id).get();
        person.setAddress(addressService.getAddress(1L));
        return person;
    }
    
}
