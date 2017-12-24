
package com.spring.gemfire.client.service;

import com.spring.gemfire.client.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Service
public class AddressService {
    
    //@Autowired
    private RestTemplate restTemplate;
    
    @CachePut(cacheNames = "Address", key = "#result.id")
    public Address saveAddress(Address address){
           //TODO
          //restTemplate.
        return address;
    }
    
    @Cacheable("Address")
    public Address getAddress(Long Id){
        return null;
    }
    
}
