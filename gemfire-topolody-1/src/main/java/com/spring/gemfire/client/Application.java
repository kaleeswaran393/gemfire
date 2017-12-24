package com.spring.gemfire.client;

import com.spring.gemfire.client.config.SpringGemFireClientConfiguration;
import com.spring.gemfire.client.gateway.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication  
@ClientCacheApplication // client and server running same machine
@EnableGemfireRepositories(basePackageClasses={PersonRepository.class})
@EnableGemfireCaching
@EnableGemfireFunctionExecutions
@CacheServerApplication   //starting embadded server
@Import(value = {SpringGemFireClientConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}


//@EnablePdx
//@EnableIndexing
//@EnableClusterConfiguration
//@EnableLogging(logLevel="info", logFile="/tmp/application.log")
//@Import(
   // SpringGemFireClientConfiguration.class
//)