package com.xingbook.zxott.zxott.service;

import com.xingbook.zxott.zxott.config.CacheConfig;
import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.mapper.xingbook.ZSpeakerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@org.springframework.cache.annotation.CacheConfig(cacheNames=CacheConfig.RESOURCE)
public class ZSpeakerService {
    private static Logger logger = LoggerFactory.getLogger(ZSpeakerService.class);

    private final ZSpeakerMapper zSpeakerMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public ZSpeakerService(ZSpeakerMapper zSpeakerMapper) {
        this.zSpeakerMapper = zSpeakerMapper;
    }

    @Cacheable
    public ZSpeaker selectByPrimaryKey(Integer id) {
        return zSpeakerMapper.selectByPrimaryKey(id);
    }

    @CacheEvict
    public void CacheEvict(Integer id) {
        logger.debug("清除缓存");
    }

    @Async
    public void asyc() {
        try {
            Thread.sleep(3000L);
            logger.debug("等待三秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}