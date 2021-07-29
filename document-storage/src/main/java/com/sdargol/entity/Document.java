package com.sdargol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "barcode")
    private Long barcode;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name ="box_id", nullable = false)
    @JsonIgnore
    private Box box;

    public Document() {
    }

    public Document(Integer id, Long barcode, String title) {
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", title='" + title + '\'' +
                '}';
    }
}
