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
    @Transactional
    public Document update(Document el) {
        Document document = docRepository.getById(el.getId());
        document.setBarcode(el.getBarcode());
        document.setTitle(el.getTitle());
        return docRepository.save(document);
    }

    @Override
    public Document getById(Integer id) {
        return docRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Document delete(Integer id) {
        Document doc = docRepository.findById(id).get();
        Box box = doc.getBox();
        box.removeDocument(doc);
        boxRepository.save(box);
        return doc;
    }

    @Override
    @Transactional
    public Document create(CreateDocumentDTO doc) {
        Box box = boxRepository.findById(doc.getBoxId()).get();
        box.setDocument(doc.getDocument());
        box = boxRepository.save(box);
        Document document = box.getDocuments().stream()
                .filter(d -> d.getBarcode().equals(doc.getDocument().getBarcode()))
                .findFirst()
                .get();

        return document;
    }
}
