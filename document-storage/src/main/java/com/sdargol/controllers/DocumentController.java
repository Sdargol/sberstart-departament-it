package com.sdargol.controllers;

import com.sdargol.dto.request.CreateDocumentDTO;
import com.sdargol.entity.Document;
import com.sdargol.service.api.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    private final IDocument docService;

    @Autowired
    public DocumentController(IDocument docService) {
        this.docService = docService;
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments(){
        return ResponseEntity.ok(docService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Integer id){
        return ResponseEntity.ok(docService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody CreateDocumentDTO doc){
        return ResponseEntity.ok(docService.create(doc));
    }

    @PutMapping
    public ResponseEntity<Document> updateDocument(@RequestBody Document document){
        return ResponseEntity.ok(docService.update(document));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Document> deleteDocument(@PathVariable Integer id){
        return ResponseEntity.ok(docService.delete(id));
    }
}
