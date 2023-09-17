package edu.mum.cs.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.Repo.GenaricRepoImp;

public class GenericService<T>  implements BaseSerivce<T>{

	private final EntityManager entityManager;
    private final GenaricRepoImp<T> genericDao;

    public GenericService(EntityManager entityManager, GenaricRepoImp<T> genericDao) {
        this.entityManager = entityManager;
        this.genericDao = genericDao;
    }

    @Override
    public List<T> findAll() {
        return genericDao.FindAll(entityManager);
    }

    @Override
    public T findById(Long id) {
        return genericDao.findById(id, entityManager);
    }

    @Override
    public void insert(T entity) {
        genericDao.insert(entity, entityManager);
    }

    @Override
    public void delete(T entity) {
        genericDao.delete(entity, entityManager);
    }
}
