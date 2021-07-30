package com.sdargol.controllers;

import com.sdargol.dto.response.MessageDTO;
import com.sdargol.entity.Box;
import com.sdargol.service.api.IBox;
import com.sdargol.service.exceptions.ServiceOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
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
        return ResponseEntity.ok(box);
    }

    @PostMapping
    public ResponseEntity<Box> createBox(@RequestBody Box box){
        Box boxSave = boxService.create(box);
        return ResponseEntity.ok(boxSave);
    }

    @PutMapping
    public ResponseEntity<Box> updateBox(@RequestBody Box box) throws ServiceOperationException {
        Box updateBox = boxService.update(box);
        return ResponseEntity.ok(updateBox);
    }

    @ExceptionHandler(ServiceOperationException.class)
    public ResponseEntity<MessageDTO> exceptionsHandler(ServiceOperationException ex){
        return ResponseEntity.ok(new MessageDTO(ex.getMessage()));
    }
}
