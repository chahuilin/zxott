package com.xingbook.zxott.zxott.controller;

import com.xingbook.zxott.zxott.entity.ZSpeaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeControllerTest {
    @Autowired
    private
    WelcomeController controller;

    @Test
    public void welcome() throws Exception {
    }

    @Test
    public void testCache() throws Exception {
        ZSpeaker zSpeaker = controller.testCache(1);
        System.out.print(zSpeaker);


    }

    @Test
    public void cacheEvict() throws Exception {
    }

}