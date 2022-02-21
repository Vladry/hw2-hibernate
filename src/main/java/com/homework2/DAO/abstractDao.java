package com.homework2.DAO;

import java.util.ArrayList;
import java.util.List;

public abstract class abstractDao<T> implements Dao<T> {
    protected final List<T> col = new ArrayList<T>();

    @Override
    public T save(T obj) {
        col.add(obj);
        return obj;
    }

    @Override
    public boolean delete(T obj) {
        try {
            col.remove(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteAll(List<T> entities) {
        col.clear();
    }

    @Override
    public void saveAll(List<T> entities) {
        col.addAll(entities);
    }

    @Override
    public List<T> findAll() {
        return col;
    }

    @Override
    public boolean deleteById(long id) {
        try {
            col.remove( (int)id );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T getOne(long id) {

        try {
            return col.get( (int)id );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
