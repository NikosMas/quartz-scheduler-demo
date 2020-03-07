package com.schdl.test.web.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schdl.test.web.controller.NewsController;

/**
 * Resource entity to be returned at {@link NewsController#getNews()}
 */
public class NewsNestedDataResponse {

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Value")
    private String value;

    public NewsNestedDataResponse() {
    }

    public NewsNestedDataResponse(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
