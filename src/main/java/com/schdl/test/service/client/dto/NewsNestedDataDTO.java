package com.schdl.test.service.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsNestedDataDTO {

    private String Key;
    private String Value;

    public NewsNestedDataDTO() {
    }

    public String getKey() {
        return Key;
    }

    @JsonProperty("Key")
    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        Value = value;
    }
}
