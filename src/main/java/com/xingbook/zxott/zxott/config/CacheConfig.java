package com.xingbook.zxott.zxott.config;

import com.xingbook.zxott.zxott.common.MyKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    public static final String RESOURCE="RESOURCE";

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheConfig(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    public RedisCache redisCache() {
        return new RedisCache(RESOURCE,"ZXOTT_RESOURCE_".getBytes(),redisTemplate,60*60);
    }

    @Bean
    public CacheManager cacheManager(RedisCache redisCache) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(redisCache));
        return cacheManager;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new MyKeyGenerator();
    }


}
