package com.zte.web.myproject7.service;

public interface ICacheService {
    /**
     * 设置键值
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     *
     * @param key
     * @param increament
     * @return
     */
    Long incrBy(String key, long increament);

    String get(String key);
}
