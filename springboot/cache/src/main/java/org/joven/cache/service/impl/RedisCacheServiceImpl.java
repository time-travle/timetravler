package org.joven.cache.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.base.entity.ResponseBody;
import org.joven.cache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisCacheServiceImpl implements RedisCacheService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public List<Map<String, Object>> list(Map<String, Object> params) {
        String keyIn = (String) params.get("key");
        Set<String> keys = null;
        if (StringUtils.isBlank(keyIn)) {
            keys = redisTemplate.keys("*");
        } else {
            keys = redisTemplate.keys("*" + keyIn + "*");
        }
        List<Map<String, Object>> res = new ArrayList<>();
        for (String key : keys) {
            res.add(getValue(key));
        }
        log.debug("all res in redis {}", res);
        return res;
    }

    @Override
    public Map<String, Object> get(String cacheKey) {

        return getValue("*" + cacheKey + "*");
    }

    @Override
    public ResponseBody save(Map<String, Object> cacheData) {
        log.debug("save data :{}", cacheData);
        String typeInRedis = (String) cacheData.get("type");
        String dataKey = (String) cacheData.get("key");
        Long expireSeconds = (Long) cacheData.get("expireSeconds");
        if (expireSeconds == null) {
            expireSeconds = 24 * 60 * 60L;
        } else {
            expireSeconds = (expireSeconds - new Date().getTime()) / 1000;
        }
        switch (typeInRedis) {
            case "hash":
                setMapDataInRedis(dataKey, (Map) cacheData.get("value"), expireSeconds);
                break;
            case "list":
                setListDataInRedis(dataKey, (List) cacheData.get("value"), expireSeconds);
                break;
            case "set":
                setSetDataInRedis(dataKey, (List) cacheData.get("value"), expireSeconds);
                break;
            case "zset":
                setZSetDataInRedis(dataKey, (List) cacheData.get("value"), expireSeconds);
                break;
            default:
        }
        return new ResponseBody();
    }

    private void setZSetDataInRedis(String dataKey, List value, long expireSeconds) {
        redisTemplate.delete(dataKey);
        if (value.size() == 0) {
            return;
        }
        for (int i = 0; i < value.size(); i++) {
            redisTemplate.boundZSetOps(dataKey).add(value.get(i), i + 1);
        }
        redisTemplate.expire(dataKey, expireSeconds, TimeUnit.SECONDS);
    }

    private void setSetDataInRedis(String dataKey, List value, long expireSeconds) {
        redisTemplate.delete(dataKey);
        if (value.size() == 0) {
            return;
        }
        for (Object o : value) {
            redisTemplate.boundSetOps(dataKey).add(o);
        }
        redisTemplate.expire(dataKey, expireSeconds, TimeUnit.SECONDS);
    }

    private void setListDataInRedis(String dataKey, List value, long expireSeconds) {
        redisTemplate.delete(dataKey);
        if (value.size() == 0) {
            return;
        }
        redisTemplate.opsForList().leftPushAll(dataKey, value);
        redisTemplate.expire(dataKey, expireSeconds, TimeUnit.SECONDS);
    }

    private void setMapDataInRedis(String dataKey, Map value, long expireSeconds) {
        redisTemplate.delete(dataKey);
        if (value.size() == 0) {
            return;
        }
        redisTemplate.opsForHash().putAll(dataKey, value);
        redisTemplate.expire(dataKey, expireSeconds, TimeUnit.SECONDS);
    }

    @Override
    public ResponseBody update(Map<String, Object> cacheData) {
        return new ResponseBody();
    }

    @Override
    public ResponseBody delete(List<String> cacheIds) {
        redisTemplate.delete(cacheIds);
        return new ResponseBody();
    }

    /**
     * 获取值的失效时间
     */
    private long getExpireSecondByKey(String key, TimeUnit timeUnit) {
        return timeUnit == null ? redisTemplate.getExpire(key) : redisTemplate.getExpire(key, timeUnit);
    }

    private void setExpireTime(String key, long timeout, TimeUnit timeUnit) {
        if (timeUnit == null) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        } else {
            redisTemplate.expire(key, timeout, timeUnit);
        }
    }

    private Map<String, Object> getValue(String key) {
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        DataType dataType = redisTemplate.type(key);
        log.debug("data key is {}", key);
        log.debug("data dataType.code is {}", dataType.code());
        Map<String, Object> res = new HashMap<>();
        res.put("key", key);
        Long timeExpire = redisTemplate.getExpire(key);
        if (timeExpire != -1) {
            SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            res.put("expireSeconds", longDateFormat.format(new Date(new Date().getTime() + redisTemplate.getExpire(key) * 1000)));
        } else {
            res.put("expireSeconds", "未设置");
        }
        String datatype = dataType.code();
        res.put("type", datatype);
        switch (datatype) {
            case "string":
                res.put("value", redisTemplate.opsForValue().get(key, 0, -1));
                break;
            case "list":
                res.put("value", redisTemplate.boundListOps(key).range(0, redisTemplate.boundListOps(key).size()));
                break;
            case "set":
                res.put("value", redisTemplate.opsForSet().members(key));
                break;
            case "zset":
                res.put("value", redisTemplate.opsForZSet().range(key, 0, -1));
                break;
            case "hash":
                res.put("value", redisTemplate.opsForHash().entries(key));
                break;
            default:
        }
        return res;
    }

    /**
     * 获得不同的数据类型的值
     */
    private void getNormalValue(String normalKey) {
        redisTemplate.opsForValue();
    }

    private void getListValue(String listKey) {
    }

    private void getHashValue(String hashKey) {
    }

    private void getSetValue(String setKey) {
    }

    private void getZSetValue(String zSetKey) {
    }

    private void getSortedSetValue(String sortedSetKey) {
    }

}
