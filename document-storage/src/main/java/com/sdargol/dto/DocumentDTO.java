package com.sdargol.dto;

public class DocumentDTO {
    private Integer id;
    private Long barcode;
    private String title;

    public DocumentDTO() {
    }

    public DocumentDTO(Integer id, Long barcode, String title) {
        this.id = id;
        this.barcode = barcode;
        this.title = title;
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
}
