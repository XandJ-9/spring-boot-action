package com.bookcode.controller;

import com.bookcode.task.ScheduleTask;
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
    ScheduleTask scheduleTask;

    @GetMapping("/updateCron")
    public String updateCron(String cron){
        log.info("new cron: {}", cron);
        scheduleTask.setCron(cron);
        return "ok";
    }



}
