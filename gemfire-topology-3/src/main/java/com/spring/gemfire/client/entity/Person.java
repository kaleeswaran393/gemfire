package com.spring.gemfire.client.entity;

import com.spring.gemfire.client.entity.Address;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;

@Data
@Region("Person")
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String firstName;
	private String lastName;
        
        private Address address;

	
}
