package com.schdl.test.service.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MainNewsInfoDTO {

    private List<NewsNestedDataDTO> Data;
    private String FileName;
    private String FilePath;
    private Integer ID;
    private Boolean IsFile;

    public MainNewsInfoDTO() {
    }

    public String getFileName() {
        return FileName;
    }

    @JsonProperty("FileName")
    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFilePath() {
        return FilePath;
    }

    @JsonProperty("FilePath")
    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public Integer getID() {
        return ID;
    }

    @JsonProperty("ID")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Boolean getFile() {
        return IsFile;
    }

    @JsonProperty("IsFile")
    public void setFile(Boolean file) {
        IsFile = file;
    }

    public List<NewsNestedDataDTO> getData() {
        return Data;
    }

    @JsonProperty("Data")
    public void setData(List<NewsNestedDataDTO> data) {
        Data = data;
    }
}
