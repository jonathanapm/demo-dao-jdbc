package model.dao;

import model.entities.Department;

import java.util.List;

public interface CrudDAO<T> {

    void insert(T crudObject);

    void update(T crudObject);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();
}
