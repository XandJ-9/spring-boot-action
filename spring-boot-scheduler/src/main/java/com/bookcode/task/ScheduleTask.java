package com.bookcode.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
@PropertySource("classpath:/task-config.ini")
public class ScheduleTask implements SchedulingConfigurer {

    @Value("${printTime.cron}")
    private String cron;

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                // 线程任务
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Current time: {}", LocalDateTime.now());
                    }
                },
                // 定义触发器
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {

                        CronTrigger cronTrigger = new CronTrigger(cron);
                        return cronTrigger.nextExecutionTime(triggerContext);
//                        PeriodicTrigger periodicTrigger = new PeriodicTrigger(1000L);
//                        Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
//                        return nextExecutionTime;
                    }
                });
    }
}
