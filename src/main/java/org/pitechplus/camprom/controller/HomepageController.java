package org.pitechplus.camprom.controller;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomepageController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/endpointA")
    public void handlerA() throws InterruptedException {
        logger.info("/endpointA");
        Thread.sleep(RandomUtils.nextLong(0, 100));
    }

    @RequestMapping("/endpointB")
    public void handlerB() throws InterruptedException {
        logger.info("/endpointB");
        Thread.sleep(RandomUtils.nextLong(0, 100));
    }
}
