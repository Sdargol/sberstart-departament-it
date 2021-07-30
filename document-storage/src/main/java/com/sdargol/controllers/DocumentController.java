package com.sdargol.controllers;

import com.sdargol.dto.request.CreateDocumentDTO;
import com.sdargol.entity.Document;
import com.sdargol.service.api.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    private final IDocument docService;

    @Autowired
    public DocumentController(IDocument docService) {
        this.docService = docService;
    }

    public ResponseEntity<List<Document>> getAllDocuments(){
        return null;
    }
    public ResponseEntity<Document> getDocumentById(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody CreateDocumentDTO doc){
        return ResponseEntity.ok(docService.create(doc));
    }
    public ResponseEntity<Document> updateDocument(){
        return null;
    }
    public ResponseEntity<Document> deleteDocument(){
        return null;
    }
}
