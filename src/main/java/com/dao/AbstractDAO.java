package com.dao;

/**
 * Created by Edvard Piri on 12.11.2017.
 */
public interface AbstractDAO<T> {
    T save(T t);

}
