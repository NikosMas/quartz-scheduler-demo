package com.schdl.test.web.controller;

import com.schdl.test.service.NewsInfoService;
import com.schdl.test.service.SchedulerService;
import com.schdl.test.web.payload.MainNewsInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
public class NewsController {

    private final SchedulerService schedulerService;
    private final NewsInfoService newsInfoService;

    @Autowired
    public NewsController(SchedulerService schedulerService, NewsInfoService newsInfoService) {
        this.schedulerService = schedulerService;
        this.newsInfoService = newsInfoService;
    }

    @GetMapping("start")
    public String saveNews() {
        schedulerService.startScheduler();
        return "Scheduler started!";
    }

    @GetMapping("getMyNews")
    public List<MainNewsInfoResponse> getNews() {
        return newsInfoService.getMainNewsInfoWithData();
    }
}
