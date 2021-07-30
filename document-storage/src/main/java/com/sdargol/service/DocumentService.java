package com.sdargol.service;

import com.sdargol.entity.Box;
import com.sdargol.entity.Document;
import com.sdargol.dto.request.CreateDocumentDTO;
import com.sdargol.repository.BoxRepository;
import com.sdargol.repository.DocumentRepository;
import com.sdargol.service.api.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DocumentService implements IDocument {
    private final DocumentRepository docRepository;
    private final BoxRepository boxRepository;

    @Autowired
    public DocumentService(DocumentRepository docRepository, BoxRepository boxRepository) {
        this.docRepository = docRepository;
        this.boxRepository = boxRepository;
    }


    @Override
    public List<Document> getAll() {
        return docRepository.findAll();
    }

    @Override
    public Document update(Document el) {
        return null;
    }

    @Override
    public Document getById(Integer id) {
        return null;
    }

    @Override
    public Document delete(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Document create(Object doc) {
        CreateDocumentDTO docDTO = (CreateDocumentDTO) doc;
        Box box = boxRepository.findById(docDTO.getBoxId()).get();
        box.setDocument(docDTO.getDocument());
        box = boxRepository.save(box);
        Document document = box.getDocuments().stream()
                .filter(d -> d.getBarcode().equals(docDTO.getDocument().getBarcode()))
                .findFirst()
                .get();

        return document;
    }
}
