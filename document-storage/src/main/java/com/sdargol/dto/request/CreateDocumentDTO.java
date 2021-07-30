package com.sdargol.dto.request;

import com.sdargol.entity.Document;

public class CreateDocumentDTO {
    private Integer boxId;
    private Document document;

    public CreateDocumentDTO() {
    }

    public CreateDocumentDTO(Integer boxId, Document document) {
        this.boxId = boxId;
        this.document = document;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
