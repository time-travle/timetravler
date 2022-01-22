package org.joven.cache.controller;

import org.joven.base.entity.ResponseBody;
import org.joven.cache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cache/control")
public class RedisCacheController {
    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping("list")
    public List<Map<String, Object>> list(Map<String, Object> params) {
        return redisCacheService.list(params);
    }

    @GetMapping("{cacheId}")
    public List<Map<String, Object>> get(@PathVariable("cacheId") String cacheKey) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", cacheKey);
        return redisCacheService.list(params);
    }

    @PostMapping("save")
    public ResponseBody saveToCache(@RequestBody Map<String, Object> cacheData) {
        return redisCacheService.save(cacheData);
    }

    @PostMapping("update")
    public ResponseBody update(@RequestBody Map<String, Object> cacheData) {
        return redisCacheService.update(cacheData);
    }

    @PostMapping("delete")
    public ResponseBody delete(@RequestBody List<String> cacheKeys) {
        return redisCacheService.delete(cacheKeys);
    }
}
