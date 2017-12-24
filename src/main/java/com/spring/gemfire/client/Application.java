package com.spring.gemfire.client;

import com.spring.gemfire.client.config.SpringGemFireClientConfiguration;
import java.util.Collections;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.config.annotation.ClientCacheConfigurer;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableIndexing;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.config.annotation.EnablePool;
import org.springframework.data.gemfire.config.annotation.EnablePool.Server;
import org.springframework.data.gemfire.config.annotation.EnablePools;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.gemfire.support.ConnectionEndpoint;

@SpringBootApplication
//@Import(
   // SpringGemFireClientConfiguration.class
//)
@ClientCacheApplication(logLevel = "debug",locators = {@Locator(host = "localhost", port = 10336)})


@EnableGemfireRepositories

@EnableGemfireCaching

//@EnablePdx

//@EnableIndexing

//@EnableClusterConfiguration

@EnableGemfireFunctionExecutions

//@EnableLogging(logLevel="info", logFile="/tmp/application.log")
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
