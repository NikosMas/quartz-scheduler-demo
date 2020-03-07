package com.schdl.test.domain;

import com.schdl.test.service.client.dto.MainNewsInfoDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Object entity to map and store the main data returned
 * from "Δελτία Τύπου Επιτροπής Ανταγωνισμού" open api.
 */
@Entity
@Table(name = "main_news")
public class MainNewsInfo {

    private String filename;
    private String filepath;
    private Integer id;
    private Boolean file;

    public MainNewsInfo() {
    }

    public MainNewsInfo(MainNewsInfoDTO ni) {
        this.filename = ni.getFileName();
        this.filepath = ni.getFilePath();
        this.id = ni.getID();
        this.file = ni.getFile();
    }

    @Id
    public Integer getId() {
        return id;
    }

    @Column(name = "file_name")
    public String getFilename() {
        return filename;
    }

    @Column(name = "file_path")
    public String getFilepath() {
        return filepath;
    }

    @Column(name = "is_file")
    public Boolean getFile() {
        return file;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "MainNewsInfo{" +
                "  filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", id=" + id +
                ", file=" + file +
                '}';
    }
}
