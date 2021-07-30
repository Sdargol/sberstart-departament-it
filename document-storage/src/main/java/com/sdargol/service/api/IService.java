package com.sdargol.service.api;

import java.util.List;

public interface IService<T, D>{
    List<T> getAll();
    T create(D el);
    T update(T el);
    T getById(Integer id);
    T delete(Integer id);
}
