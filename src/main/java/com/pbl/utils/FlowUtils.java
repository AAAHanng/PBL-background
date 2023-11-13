package com.pbl.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 限流通用工具
 * 针对于不同的情况进行限流操作，支持限流升级
 */
@Slf4j
@Component
public class FlowUtils {
    @Resource
    StringRedisTemplate template;
    /**
     * 针对于单次频率限制，请求成功后，在冷却时间内不得再次进行请求
     * 如3秒内不能再次发起请求，如果不听劝阻继续发起请求，将限制更长时间
     * @param key 键
     * @param frequency 请求频率
     * @param baseTime 基础限制时间
     * @param upgradeTime 升级限制时间
     * @return 是否通过限流检查
     */
//    public boolean limitOnceUpgradeCheck(String key, int frequency, int baseTime, int upgradeTime){
//        return this.internalCheck(key, frequency, baseTime, (overclock) -> {
//            if (overclock)
//                template.opsForValue().set(key, "1", upgradeTime, TimeUnit.SECONDS);
//            return false;
//        });
//    }
}
