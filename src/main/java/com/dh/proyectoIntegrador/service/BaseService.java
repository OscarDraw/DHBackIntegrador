package com.dh.proyectoIntegrador.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    public T save(T element);
    public List<T> getAll();
    public boolean delete(Integer id);
    public T modify(T element);
    public T getById(Integer id);
}
