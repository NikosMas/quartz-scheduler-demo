package com.schdl.test.service;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.schdl.test.utils.GlobalConstants.JOB_KEY;

@Service
public class SchedulerService {

    private static final Logger LOG = LoggerFactory.getLogger(SchedulerService.class);

    private final Scheduler scheduler;

    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * Trigger the running {@link Scheduler} to execute the job with key: epant_get_news
     */
    public void startScheduler() {
        try {
            LOG.info("Trigger the scheduler to execute the job with key: {}", JOB_KEY);
            scheduler.triggerJob(JobKey.jobKey(JOB_KEY));

        } catch (SchedulerException e) {
            LOG.error("Exception on trigger the {} job. Exception: {}", JOB_KEY, e.getMessage());
        }
    }

}
