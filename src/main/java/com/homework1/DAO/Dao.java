package com.homework1.DAO;

import java.util.List;

public interface Dao<T> {
    T save(T obj);

    boolean delete(T obj);//- возвращает логическое значение, был ли найден и удален объект из "базы данных"

    void deleteAll(List<T> entities);

    void saveAll(List<T> entities);

    List<T> findAll();

    boolean deleteById(long id);

    T getOne(long id);
}
