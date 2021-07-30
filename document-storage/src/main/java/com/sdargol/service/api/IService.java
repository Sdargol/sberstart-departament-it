package com.sdargol.service.api;

import java.util.List;

public interface IService<T>{
    List<T> getAll();
    T create(Object el);
    T update(T el);
    T getById(Integer id);
    T delete(Integer id);
}
