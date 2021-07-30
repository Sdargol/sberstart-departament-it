package com.sdargol.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="boxes")
public class Box{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "barcode")
    private Long barcode;

    @Column(name = "title")
    private String title;

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "box_id")
    @OneToMany(mappedBy = "box", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    public Box() {
    }

    public Box(Integer id, Long barcode, String title) {
        this.id = id;
        this.barcode = barcode;
        this.title = title;
    }

    public Box(Integer id, Long barcode, String title, List<Document> documents) {
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
        documents.forEach(d -> d.setBox(this));
        this.documents = documents;
    }

    public void setDocument(Document document) {
        document.setBox(this);
        documents.add(document);
    }

    public void removeDocument(Document document) {
        Document doc = documents.stream()
                .filter(d -> d.getId().equals(document.getId()))
                .findFirst()
                .get();
        documents.remove(doc);
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", title='" + title + '\'' +
                ", documents=" + documents +
                '}';
    }
}
