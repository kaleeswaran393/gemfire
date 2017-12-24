
package com.spring.gemfire.client.resource;

import com.spring.gemfire.client.entity.Address;
import com.spring.gemfire.client.entity.Person;
import com.spring.gemfire.client.service.AddressService;
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
@RequestMapping("/address")
@Slf4j
public class AddressController {
    
    @Autowired
    private AddressService addressService;
    
    @RequestMapping(method = RequestMethod.POST)
    public Address createPerson(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getPerson(@PathVariable Long id) {
        return addressService.getAddress(id);
    }
}
