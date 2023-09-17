package edu.mum.cs.Service;

import java.util.List;

public interface BaseSerivce <T> {
	
	List<T> findAll();
    T findById(Long id);
    void insert(T entity);
    void delete(T entity);
}
