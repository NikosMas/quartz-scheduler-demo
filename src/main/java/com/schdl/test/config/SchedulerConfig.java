package com.schdl.test.config;

import com.schdl.test.service.SchedulerService;
import com.schdl.test.service.job.GetNewsInfoJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.schdl.test.utils.GlobalConstants.JOB_KEY;

@Configuration
public class SchedulerConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SchedulerService.class);

    /**
     * Create a {@link JobDetail} job, set the {@link JobKey} and add it in running {@link Scheduler}
     */
    @Bean
    public Scheduler scheduler(Scheduler scheduler) throws SchedulerException {
        LOG.info("Add into scheduler the job with key: {}", JOB_KEY);
        JobKey jobKey = JobKey.jobKey(JOB_KEY);
        JobDetail job = JobBuilder.newJob(GetNewsInfoJob.class).withIdentity(jobKey).storeDurably().build();
        scheduler.addJob(job, true);
        return scheduler;
    }
}
