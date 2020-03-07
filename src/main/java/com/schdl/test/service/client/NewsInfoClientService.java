package com.schdl.test.service.client;

import com.schdl.test.service.NewsInfoService;
import com.schdl.test.service.client.dto.MainNewsInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.schdl.test.utils.GlobalConstants.EPANT_URL;

@Service
public class NewsInfoClientService {

    private static final Logger LOG = LoggerFactory.getLogger(NewsInfoClientService.class);

    private final NewsInfoService newsInfoService;
    private final RestTemplate restTemplate;

    public NewsInfoClientService(NewsInfoService newsInfoService, RestTemplate restTemplate) {
        this.newsInfoService = newsInfoService;
        this.restTemplate = restTemplate;
    }

    /**
     * Fetch data from "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api and store them into database
     */
    public void fetchNewsInfoData() {
        List<MainNewsInfoDTO> newsInfoMap = requestToEPANT();

        LOG.info("GET - request to \"Δελτία Τύπου Επιτροπής Ανταγωνισμού\" open api is successful");
        newsInfoService.saveNewsInfoAndNestedData(newsInfoMap);
    }

    /**
     * Execute GET - request to "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api,
     * using {@link RestTemplate}.
     */
    public List<MainNewsInfoDTO> requestToEPANT() {
        return Arrays.asList(Objects.requireNonNull(
                restTemplate.getForObject(EPANT_URL, MainNewsInfoDTO[].class)));
    }

}
