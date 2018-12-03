package com.duannd.springboot.caching;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * Created By ngdduan@gmail.com at 12/3/2018 10:15 AM
 */
@SpringBootApplication
@EnableCaching
public class CachingApplication {

    public static void main(String args[]) {
        SpringApplication.run(CachingApplication.class, args);
    }

    @Bean
    public Config hazelCastConfig() {
        Config config = new Config();
        config.setInstanceName("hazelcast-cache");
        var userCache = new MapConfig();
        userCache.setTimeToLiveSeconds(60);
        userCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put("userCache", userCache);
        return config;
    }

}
