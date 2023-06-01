package com.bookcode.controller;

import com.bookcode.task.CronScheduleTask;
import com.bookcode.task.PeriodScheduleTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    CronScheduleTask cronScheduleTask;
    PeriodScheduleTask periodScheduleTask;

    @GetMapping("/updateCron")
    public String updateCron(String cron){
        log.info("new cron: {}", cron);
        cronScheduleTask.setCron(cron);
        return "ok";
    }

    @GetMapping("/updateCron")
    public String updatePeriod(String period){
        log.info("new cron: {}", period);
        periodScheduleTask.setPeriod(Long.valueOf(period));
        return "ok";
    }



}
