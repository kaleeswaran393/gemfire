
package com.spring.gemfire.client.config;

import java.util.Properties;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheConfigurer;
import org.springframework.data.gemfire.support.ConnectionEndpoint;

//@Configuration
public class SpringGemFireClientConfiguration {

    static int intValue(Number value) {
        return value.intValue();
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    Properties gemfireProperties(@Value("${gemfire.log.level:config}") String logLevel) {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("log-level", logLevel);
        return gemfireProperties;
    }

    @Bean
    ClientCacheFactoryBean gemfireCache(@Qualifier("gemfireProperties") Properties gemfireProperties) {
        ClientCacheFactoryBean gemfireCache = new ClientCacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties);
        return gemfireCache;
    }

//    @Bean(name = GemfireConstants.DEFAULT_GEMFIRE_POOL_NAME)
//    PoolFactoryBean gemfirePool(
//            @Value("${gemfire.cache.server.host:localhost}") String host,
//            @Value("${gemfire.cache.server.port:40404}") int port) {
//        PoolFactoryBean gemfirePool = new PoolFactoryBean();
//        gemfirePool.setName(GemfireConstants.DEFAULT_GEMFIRE_POOL_NAME);
//        gemfirePool.setFreeConnectionTimeout(intValue(TimeUnit.SECONDS.toMillis(5)));
//        gemfirePool.setKeepAlive(false);
//        gemfirePool.setPingInterval(TimeUnit.SECONDS.toMillis(5));
//        gemfirePool.setReadTimeout(intValue(TimeUnit.SECONDS.toMillis(5)));
//        gemfirePool.setRetryAttempts(1);
//        gemfirePool.setSubscriptionEnabled(true);
//        gemfirePool.setThreadLocalConnections(false);
//        gemfirePool.setServers(Collections.singletonList(new ConnectionEndpoint(host, port)));
//        return gemfirePool;
//    }

    
    
    @Bean("Person")
    public ClientRegionFactoryBean<Object, Object> peopleRegion(GemFireCache gemfireCache) {
        ClientRegionFactoryBean<Object, Object> peopleRegion = new ClientRegionFactoryBean<>();
        peopleRegion.setCache(gemfireCache);
        //peopleRegion.setPool(gemfirePool);
        peopleRegion.setClose(false);
        peopleRegion.setShortcut(ClientRegionShortcut.PROXY);
        return peopleRegion;
    }

    @Bean("Address")
    public ClientRegionFactoryBean<Object, Object> addressRegion(GemFireCache gemfireCache) {
        ClientRegionFactoryBean<Object, Object> peopleRegion = new ClientRegionFactoryBean<>();
        peopleRegion.setCache(gemfireCache);
        peopleRegion.setClose(false);
        peopleRegion.setShortcut(ClientRegionShortcut.PROXY);
        return peopleRegion;
    }

    @Bean
    public ClientCacheConfigurer clientCachePoolPortConfigurer(
          @Value("${gemfire.cache.server.host:localhost}") String cacheServerHost,
          @Value("${gemfire.cache.server.port:48484}") int cacheServerPort) {
      return (beanName, clientCacheFactoryBean)
                -> {
                  //clientCacheFactoryBean.setServers(Collections.singletonList(new ConnectionEndpoint(cacheServerHost, cacheServerPort)));
                  clientCacheFactoryBean.addLocators(new ConnectionEndpoint("localhost",10335));
                  //clientCacheFactoryBean.setServers(Collections.singletonList(new ConnectionEndpoint("localhost", 41414)));
                  //clientCacheFactoryBean.addServers(Collections.singletonList(new ConnectionEndpoint("localhost", 42424)));
                  
      };
                
    }
    
    
}
