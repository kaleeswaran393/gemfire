
package com.spring.gemfire.client.config;

import com.spring.gemfire.client.entity.Address;
import com.spring.gemfire.client.entity.Person;
import java.util.Properties;
import org.apache.geode.cache.GemFireCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

@Configuration
public class SpringGemFireClientConfiguration {

    static int intValue(Number value) {
        return value.intValue();
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name","SpringDataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }
 
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    
    
    @Bean("Person")
    public LocalRegionFactoryBean<String, Person> peopleRegion(GemFireCache gemfireCache) {
        LocalRegionFactoryBean<String, Person> peopleRegion = new LocalRegionFactoryBean<>();
        peopleRegion.setCache(gemfireCache);
        peopleRegion.setName("Person");
        peopleRegion.setClose(false);
        return peopleRegion;
    }

    @Bean("Address")
    public LocalRegionFactoryBean<String, Address> addressRegion(GemFireCache gemfireCache) {
        LocalRegionFactoryBean<String, Address> peopleRegion = new LocalRegionFactoryBean<>();
        peopleRegion.setCache(gemfireCache);
        peopleRegion.setClose(false);
        peopleRegion.setName("Address");
        return peopleRegion;
    }

//    @Bean
//     CacheServerConfigurer cacheServerPortConfigurer(
//          @Value("${gemfire.cache.server.host:localhost}") String cacheServerHost,
//          @Value("${gemfire.cache.server.port:40404}") int cacheServerPort) {
//      return (beanName, cacheServerFactoryBean) -> {
//          cacheServerFactoryBean.setBindAddress(cacheServerHost);
//          cacheServerFactoryBean.setHostNameForClients(cacheServerHost);
//          cacheServerFactoryBean.setPort(cacheServerPort);
//      };
  //}
}
