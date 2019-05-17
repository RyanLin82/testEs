package org.cmsideproject.config;

import java.util.Arrays;

import org.cmsideproject.component.TicketIndicesAlias;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
  
    @Bean
    public TicketIndicesAlias customerDataService() {
        return new TicketIndicesAlias();
    }
 
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
          new ConcurrentMapCache("test"), 
          new ConcurrentMapCache("test2"),
          new ConcurrentMapCache("test3"),
          new ConcurrentMapCache("test4")));
        return cacheManager;
    }
}
