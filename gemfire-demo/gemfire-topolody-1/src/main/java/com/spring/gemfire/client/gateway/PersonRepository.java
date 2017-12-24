package com.spring.gemfire.client.gateway;

import com.spring.gemfire.client.entity.Person;
import java.util.List;
import org.apache.geode.cache.client.ClientCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>  {

	List<Person> findByLastName(@Param("name") String name);

}
