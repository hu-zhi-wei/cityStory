package com.ryan.citystory.service;


import java.util.List;

public interface BaseService<T, E> {

    void save(T t);

    void edit(T t);

    void delete(E e);

    List<T> findByObject(T t);
}
