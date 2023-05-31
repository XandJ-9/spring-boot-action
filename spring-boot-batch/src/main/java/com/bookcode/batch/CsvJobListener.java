package com.bookcode.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener {

    long start;
    long end;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        start = System.currentTimeMillis();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        end = System.currentTimeMillis();
        System.out.println("任务结束， 耗时: " + (end- start) + "ms");
    }
}
