package org.joven.cache.service;

import org.joven.base.entity.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * redis 缓存增删改查
 */
public interface RedisCacheService {

    List<Map<String, Object>> list(Map<String, Object> params);

    Map<String, Object> get(String cacheId);

    ResponseBody save(Map<String, Object> cacheData);

    ResponseBody update(Map<String, Object> cacheData);

    ResponseBody delete(List<String> cacheIds);
}
