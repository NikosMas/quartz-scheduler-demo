package com.schdl.test.domain;

import com.schdl.test.service.client.dto.NewsNestedDataDTO;

import javax.persistence.*;

/**
 * Object entity to map and store the nested data in main body response
 * from "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api.
 */
@Entity
@Table(name = "news_data")
public class NewsNestedData {

    private Integer id;
    private String key;
    private String value;

    /**
     * Id of {@link MainNewsInfo} entity
     */
    private Integer mainNewsId;

    public NewsNestedData() {
    }

    public NewsNestedData(NewsNestedDataDTO data, Integer mainNewsId) {
        this.key = data.getKey();
        this.value = data.getValue();
        this.mainNewsId = mainNewsId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Column(name = "main_news_id")
    public Integer getMainNewsId() {
        return mainNewsId;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMainNewsId(Integer mainNewsId) {
        this.mainNewsId = mainNewsId;
    }

    @Override
    public String toString() {
        return "NewsNestedData{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", mainNewsId=" + mainNewsId +
                '}';
    }
}
