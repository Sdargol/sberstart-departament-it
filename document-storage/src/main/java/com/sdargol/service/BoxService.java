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
    public Box create(Box el) {
        return boxRepository.save(el);
    }

    @Override
    @Transactional
    public Box update(Box el) {
        Box boxSrc = boxRepository.findById(el.getId()).get();
        boxSrc.setTitle(el.getTitle());
        boxSrc.setBarcode(el.getBarcode());
        return boxRepository.save(boxSrc);
    }

    @Override
    public Box getById(Integer id) {
        return boxRepository.findById(id).get();
    }

    @Override
    public Box delete(Integer id) {
        Box box = boxRepository.getById(id);
        boxRepository.delete(box);
        return box;
    }
}
