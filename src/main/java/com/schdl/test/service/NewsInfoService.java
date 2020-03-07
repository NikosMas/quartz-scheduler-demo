package com.schdl.test.service;

import com.schdl.test.domain.MainNewsInfo;
import com.schdl.test.domain.NewsNestedData;
import com.schdl.test.domain.repository.MainNewsInfoRepository;
import com.schdl.test.domain.repository.NewsNestedDataRepository;
import com.schdl.test.service.client.dto.MainNewsInfoDTO;
import com.schdl.test.service.client.dto.NewsNestedDataDTO;
import com.schdl.test.web.payload.MainNewsInfoResponse;
import com.schdl.test.web.payload.NewsNestedDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(NewsInfoService.class);

    private final NewsNestedDataRepository newsNestedDataRepository;
    private final MainNewsInfoRepository mainNewsInfoRepository;

    public NewsInfoService(NewsNestedDataRepository newsNestedDataRepository, MainNewsInfoRepository mainNewsInfoRepository) {
        this.newsNestedDataRepository = newsNestedDataRepository;
        this.mainNewsInfoRepository = mainNewsInfoRepository;
    }

    /**
     * Fetch data required from database to build the {@link MainNewsInfoResponse} resources
     *
     * @return a list of {@link MainNewsInfoResponse} resources
     */
    public List<MainNewsInfoResponse> getMainNewsInfoWithData() {
        LOG.info("Fetch all MainNewsInfo & NewsNestedData data from database");
        final List<NewsNestedData> newsNestedData = getAllNewsNestedData();

        return getAllMainNewsInfo()
                .stream()
                .map(mni -> new MainNewsInfoResponse(
                        getNewsNestedDataResources(newsNestedData, mni.getId()),
                        mni.getFilename(),
                        mni.getFilepath(),
                        mni.getId(),
                        mni.getFile()))
                .collect(Collectors.toList());
    }

    /**
     * Deserialize the response body from "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api and save the data.
     *
     * @param newsInfos a {@link LinkedHashMap} map with the response body from "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveNewsInfoAndNestedData(List<MainNewsInfoDTO> newsInfos) {
        LOG.info("Store response data to database after deserialization");

        List<NewsNestedData> newsNestedDataList = new ArrayList<>();
        newsInfos.forEach(ni -> {
            MainNewsInfo newsInfo = mainNewsInfoRepository.save(new MainNewsInfo(ni));

            List<NewsNestedDataDTO> data = ni.getData();
            data.forEach(d -> newsNestedDataList.add(new NewsNestedData(d, newsInfo.getId())));
        });

        newsNestedDataRepository.saveAll(newsNestedDataList);
    }

    /**
     * Build the {@link NewsNestedDataResponse} resources for each MainNewsInfoResource
     *
     * @param newsNestedData the list of all {@link NewsNestedData} entities to be filtered
     * @param mniId          the Id of {@link MainNewsInfo} entity
     * @return a list of {@link NewsNestedDataResponse} resources
     */
    private List<NewsNestedDataResponse> getNewsNestedDataResources(List<NewsNestedData> newsNestedData, Integer mniId) {
        return newsNestedData
                .stream()
                .filter(nd -> nd.getMainNewsId().equals(mniId))
                .map(d -> new NewsNestedDataResponse(d.getKey(), d.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * @return a list of {@link NewsNestedData} entities
     */
    private List<NewsNestedData> getAllNewsNestedData() {
        return newsNestedDataRepository.findAll();
    }

    /**
     * @return a list of {@link MainNewsInfo} entities
     */
    private List<MainNewsInfo> getAllMainNewsInfo() {
        return mainNewsInfoRepository.findAll();
    }
}
