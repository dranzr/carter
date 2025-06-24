package com.carter;

import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {

  @Bean
  public CacheManager cacheManager() {
    ConcurrentMapCacheManager manager = new ConcurrentMapCacheManager();
    manager.setAllowNullValues(false);
    manager.setCacheNames(List.of("productCache"));
    return manager;
  }
}
