package com.luongvandat.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class GeneralRepository<T, ID> {
    private EntityManager entityManager;
    private String entityName;

    public GeneralRepository(String entityName) {
        this.entityName = entityName;
        entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public T add(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
        return entity;
    }

    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("select e from " + entityName + " e", entityName.getClass()).getResultList();
    }

    public T findOneById(T entity, ID id) {
        return (T) entityManager.find(entity.getClass(), id);
    }

    public T removeById(T entity, ID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(findOneById(entity, id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
        return entity;
    }

    public T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
        return entity;
    }
}