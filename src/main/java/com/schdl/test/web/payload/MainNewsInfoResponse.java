package com.schdl.test.web.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schdl.test.web.controller.NewsController;

import java.util.List;

/**
 * Resource entity to be returned at {@link NewsController#getNews()}
 */
public class MainNewsInfoResponse {

    @JsonProperty("Data")
    private List<NewsNestedDataResponse> data;

    @JsonProperty("FileName")
    private String filename;

    @JsonProperty("FilePath")
    private String filepath;

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("IsFile")
    private Boolean file;

    public MainNewsInfoResponse() {
    }

    public MainNewsInfoResponse(List<NewsNestedDataResponse> data, String filename, String filepath, Integer id, Boolean file) {
        this.data = data;
        this.filename = filename;
        this.filepath = filepath;
        this.id = id;
        this.file = file;
    }

    public List<NewsNestedDataResponse> getData() {
        return data;
    }

    public void setData(List<NewsNestedDataResponse> data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFile() {
        return file;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }
}
