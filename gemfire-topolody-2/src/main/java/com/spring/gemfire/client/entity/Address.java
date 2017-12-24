
package com.spring.gemfire.client.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
@Region("Address")
public class Address implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    private String address;
    private String unit;
    private String postal;
  
}
