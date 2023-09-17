package edu.mum.cs.Repo;

import java.util.List;

import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class GenaricRepoImp<T> implements GenaricRepo<T> {
	private final EntityManager entityManager;
    private final Class<T> entityClass;

    public GenaricRepoImp(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public List<T> FindAll(EntityManager entityManager) {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    @Override
    public T findById(Long id,EntityManager entityManager) {
        T entity = entityManager.find(entityClass, id);
        if (entity == null) {
            throw new EntityNotFoundException("Can't find entity for ID " + id);
        }
        return entity;
    }

    @Override
    public void insert(T entity,EntityManager entityManager) {
    	try {
            Field idField = entityClass.getDeclaredField("id");
            idField.setAccessible(true);
            Long id = (Long) idField.get(entity);
            if (id != null && id > 0) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access or retrieve ID using reflection.", e);
        }
    }

    @Override
    public void delete(T entity,EntityManager entityManager) {
    	try {
            Field idField = entityClass.getDeclaredField("id");
            idField.setAccessible(true);
            Long id = (Long) idField.get(entity);
            if (id != null && id > 0) {
                T entityToDelete = entityManager.find(entityClass, id);
                if (entityToDelete != null) {
                    entityManager.remove(entityToDelete);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access or retrieve ID using reflection.", e);
        }





    }
}


