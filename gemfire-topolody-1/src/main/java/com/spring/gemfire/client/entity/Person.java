package com.spring.gemfire.client.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

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
