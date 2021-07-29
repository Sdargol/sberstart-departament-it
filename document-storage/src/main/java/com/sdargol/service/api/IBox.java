package com.sdargol.service.api;

import com.sdargol.entity.Box;

import java.util.List;

public interface IBox {
    List<Box> getAll();
    Box create(Box box);
    Box update(Box box);
    Box getById(Integer id);
    Box delete(Integer id);
}
