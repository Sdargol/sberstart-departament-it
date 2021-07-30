package com.sdargol.service.api;

import com.sdargol.service.exceptions.ServiceOperationException;

import java.util.List;

public interface IService<T, D>{
    List<T> getAll();
    T create(D el);
    T update(T el) throws ServiceOperationException;
    T getById(Integer id);
    T delete(Integer id);
}
