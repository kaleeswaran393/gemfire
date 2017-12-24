package com.spring.gemfire.client;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@ClientCacheApplication(logLevel = "debug",locators = {@Locator(host = "localhost", port = 10336)})
@EnableGemfireRepositories
@EnableGemfireCaching
@EnableGemfireFunctionExecutions

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
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

}


//@EnablePdx
//@EnableIndexing
//@EnableClusterConfiguration
//@EnableLogging(logLevel="info", logFile="/tmp/application.log")
//@Import(
   // SpringGemFireClientConfiguration.class
//)