package com.sdargol.service;

import com.sdargol.entity.Box;
import com.sdargol.repository.BoxRepository;
import com.sdargol.service.api.IBox;
import com.sdargol.service.exceptions.ServiceOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Box update(Box el) throws ServiceOperationException {
        //Box boxSrc = boxRepository.findById(el.getId()).get();
        Optional<Box> boxOptional = boxRepository.findById(el.getId());

        if(!boxOptional.isPresent()){
            throw new ServiceOperationException("Сущность не найдена");
        }

        Box box = boxOptional.get();

        box.setTitle(el.getTitle());
        box.setBarcode(el.getBarcode());
        return boxRepository.save(box);
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
