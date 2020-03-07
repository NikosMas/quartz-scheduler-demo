package com.schdl.test.service.job;

import com.schdl.test.service.client.NewsInfoClientService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * GetNewsInfoJob - {@link QuartzJobBean} to execute GET - request to "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api,
 * deserialize the response data and store them to H2 database.
 */
public class GetNewsInfoJob extends QuartzJobBean {

    private final NewsInfoClientService newsInfoClientService;

    @Autowired
    public GetNewsInfoJob(NewsInfoClientService newsInfoClientService) {
        this.newsInfoClientService = newsInfoClientService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        newsInfoClientService.fetchNewsInfoData();
    }

}
