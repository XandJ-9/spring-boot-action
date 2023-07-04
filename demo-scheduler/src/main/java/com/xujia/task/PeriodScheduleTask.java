package com.xujia.task;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Data
@Component
@PropertySource("classpath:/task-config.ini")
public class PeriodScheduleTask implements SchedulingConfigurer {

    @Value("${printTime.period}")
    private Long period = 1000L;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                new Runnable() {
                    @Override
                    public void run() {
                        
                    }
                },
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {
                        PeriodicTrigger periodicTrigger = new PeriodicTrigger(period);
                        return periodicTrigger.nextExecutionTime(triggerContext);
                    }
                });
    }
}
