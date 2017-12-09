package com.xingbook.zxott.zxott.service;

import com.xingbook.zxott.zxott.controller.WelcomeController;
import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.mapper.xingbook.ZSpeakerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ZSpeakerService {
    private static Logger logger = LoggerFactory.getLogger(ZSpeakerService.class);

    private final ZSpeakerMapper zSpeakerMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public ZSpeakerService(ZSpeakerMapper zSpeakerMapper) {
        this.zSpeakerMapper = zSpeakerMapper;
    }

    @Cacheable("ZSpeaker")
    public ZSpeaker selectByPrimaryKey(Integer id) {
        return zSpeakerMapper.selectByPrimaryKey(id);
    }

    @CacheEvict("ZSpeaker")
    public void CacheEvict(Integer id) {
        logger.debug("清除缓存");
    }

}