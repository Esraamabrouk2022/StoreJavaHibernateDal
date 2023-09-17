package edu.mum.cs.Repo;

import java.util.List;
import javax.persistence.EntityManager;
public interface GenaricRepo <T>{
	List<T> FindAll(EntityManager entityManager);
    T findById(Long id, EntityManager entityManager);
    void insert(T entity, EntityManager entityManager);
    void delete(T entity, EntityManager entityManager);

}
