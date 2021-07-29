package com.sdargol.controllers;

import com.sdargol.entity.Box;
import com.sdargol.service.api.IBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/boxes")
public class BoxController{
    private final IBox boxService;

    @Autowired
    public BoxController(IBox boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public ResponseEntity<List<Box>> getAllBoxes(){
        return ResponseEntity.ok(boxService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable Integer id){
        Box box = boxService.getById(id);
        Box box1 = new Box();
        box1.setId(box.getId());
        box1.setBarcode(box.getBarcode());
        box1.setTitle(box.getTitle());
        box1.setDocuments(box.getDocuments());
        return ResponseEntity.ok(box1);
    }

    @PostMapping
    public ResponseEntity<Box> createBox(@RequestBody Box box){
        Box boxSave = boxService.create(box);
        return ResponseEntity.ok(boxSave);
    }

    @PutMapping
    public ResponseEntity<Box> updateBox(@RequestBody Box box){
        Box updateBox = boxService.update(box);
        return ResponseEntity.ok(updateBox);
    }
}
