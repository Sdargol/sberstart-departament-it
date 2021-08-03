package com.sdargol.controllers;

import com.sdargol.dto.request.CreateDocumentDTO;
import com.sdargol.dto.response.MessageDTO;
import com.sdargol.entity.Document;
import com.sdargol.service.api.IDocument;
import com.sdargol.service.exceptions.ServiceOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
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
    public ResponseEntity<Document> createDocument(@Valid @RequestBody CreateDocumentDTO doc){
        return ResponseEntity.ok(docService.create(doc));
    }

    @PutMapping
    public ResponseEntity<Document> updateDocument(@RequestBody Document document) throws ServiceOperationException {
        return ResponseEntity.ok(docService.update(document));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Document> deleteDocument(@PathVariable Integer id){
        return ResponseEntity.ok(docService.delete(id));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.ok(new MessageDTO("msg"));
    }
}
