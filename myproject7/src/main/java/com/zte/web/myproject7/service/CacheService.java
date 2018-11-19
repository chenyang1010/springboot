package com.zte.web.myproject7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CacheService {

    private static final String PLATFORM_KEY_PRE = "DTB_";

    @Autowired
    private CacheSingleService cacheSingleService;

    private ICacheService cacheService;

    @PostConstruct
    private void init(){
        this.cacheService = cacheSingleService;
    }

    protected String getStrKey(String key){
        String result = PLATFORM_KEY_PRE+key;
        return result;

    }

    public void set(String key, String value) throws Exception{
        key = getStrKey(key);
        cacheService.set(key, value);
    }
    public Long incrBy(String key, long increament){
        key = getStrKey(key);
        return cacheService.incrBy(key, increament);
    }
    public String get(String key) throws Exception{
        key = getStrKey(key);
        return cacheService.get(key);
    }
}
