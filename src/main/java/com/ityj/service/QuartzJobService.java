package com.ityj.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QuartzJobService {

    @Scheduled(cron = "*/6 * * * * ?")
    public void testQuartz() {
        log.info("running....");
    }
}
