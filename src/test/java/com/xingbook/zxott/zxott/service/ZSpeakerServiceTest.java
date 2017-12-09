package com.xingbook.zxott.zxott.service;

import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.mapper.xingbook.ZSpeakerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.*;

/**
 * Created by 12652 on 2017/12/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZSpeakerServiceTest {


    @Autowired
    private ZSpeakerService server;

    @Test
    public void selectByPrimaryKey() throws Exception {
        ZSpeaker zSpeaker = server.selectByPrimaryKey(1);

    }

    @Test
    public void cacheEvict() throws Exception {
        server.CacheEvict(1);
    }

}