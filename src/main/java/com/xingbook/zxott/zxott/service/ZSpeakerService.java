package com.xingbook.zxott.zxott.service;

import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.mapper.xingbook.ZSpeakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class ZSpeakerService {

    private final ZSpeakerMapper zSpeakerMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public ZSpeakerService(ZSpeakerMapper zSpeakerMapper) {
        this.zSpeakerMapper = zSpeakerMapper;
    }

    @Caching
    public ZSpeaker selectByPrimaryKey(Integer id) {
        return zSpeakerMapper.selectByPrimaryKey(id);
    }

}