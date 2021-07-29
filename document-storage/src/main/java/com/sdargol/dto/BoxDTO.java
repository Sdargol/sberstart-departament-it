package com.sdargol.dto;

import com.sdargol.entity.Document;

import java.util.List;

public class BoxDTO {
    private Integer id;
    private Long barcode;
    private String title;
    private List<Document> documents;

    public BoxDTO() {
    }

    public BoxDTO(Integer id, Long barcode, String title) {
        this.id = id;
        this.barcode = barcode;
        this.title = title;
    }

    public BoxDTO(Integer id, Long barcode, String title, List<Document> documents) {
        this.id = id;
        this.barcode = barcode;
        this.title = title;
        this.documents = documents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
