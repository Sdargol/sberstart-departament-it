package com.sdargol.service;

import com.sdargol.entity.Box;
import com.sdargol.repository.BoxRepository;
import com.sdargol.service.api.IBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoxService implements IBox {
    private final BoxRepository boxRepository;

    @Autowired
    public BoxService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Override
    public List<Box> getAll() {
        return boxRepository.findAll();
    }

    @Override
    public Box create(Box box) {
        return boxRepository.save(box);
    }

    @Override
    @Transactional
    public Box update(Box box) {
        Box boxSrc = boxRepository.findById(box.getId()).get();
        boxSrc.setTitle(box.getTitle());
        boxSrc.setBarcode(box.getBarcode());
        return boxRepository.save(boxSrc);
    }

    @Override
    public Box getById(Integer id) {
        return boxRepository.getById(id);
    }

    @Override
    public Box delete(Integer id) {
        Box box = boxRepository.getById(id);
        boxRepository.delete(box);
        return box;
    }
}
