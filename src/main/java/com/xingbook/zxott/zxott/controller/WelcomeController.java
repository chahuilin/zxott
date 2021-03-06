/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xingbook.zxott.zxott.controller;

import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.entity.ZSuberVip;
import com.xingbook.zxott.zxott.mapper.xingbook.ZSpeakerMapper;
import com.xingbook.zxott.zxott.mapper.xingbook_user.ZSuberVipMapper;
import com.xingbook.zxott.zxott.service.ZSpeakerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("test")
public class WelcomeController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Value("${application.message}")
    private String message;

    private final ZSuberVipMapper zSuberVipMapper;

    private final ZSpeakerMapper zSpeakerMapper;

    private final ZSpeakerService zSpeakerService;

    private final StringRedisTemplate template;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public WelcomeController(ZSpeakerMapper zSpeakerMapper, ZSuberVipMapper zSuberVipMapper, ZSpeakerService zSpeakerService, StringRedisTemplate template) {
        this.zSpeakerMapper = zSpeakerMapper;
        this.zSuberVipMapper = zSuberVipMapper;
        this.zSpeakerService = zSpeakerService;
        this.template = template;
    }

    @GetMapping("/")
    @ResponseBody
    public ZSuberVip welcome(Integer id) {
        logger.debug("application.message:{}", message);

        long count = zSpeakerMapper.countByExample(null);

        logger.debug("zSpeakerMapper计数:{}", count);

        ZSuberVip zSuberVip = zSuberVipMapper.selectByPrimaryKey(id);
        logger.debug("-------{}", zSuberVip);
        System.out.println(zSuberVip.getNickName());
        return zSuberVip;
    }

    @GetMapping("/testCache")
    @ResponseBody
    public ZSpeaker testCache(Integer id) {
        ZSpeaker zSpeaker = zSpeakerService.selectByPrimaryKey(id);
        logger.debug("-------{}", zSpeaker);
        return zSpeaker;
    }

    @GetMapping("/cacheEvict")
    @ResponseBody
    public String cacheEvict(Integer id) {
        zSpeakerService.asyc();
        zSpeakerService.CacheEvict(id);
        return "hello";
    }

    @GetMapping("/testredis")
    @ResponseBody
    public String testredis() {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            logger.debug("-------set");
            ops.set(key, "foo");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
        return "hello";
    }


}
