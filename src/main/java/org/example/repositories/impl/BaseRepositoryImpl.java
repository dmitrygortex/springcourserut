package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.BaseEntity;
import org.example.repositories.BaseRepository;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    protected BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T save(T entity) {
        if (entity.getId() == 0) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }
        return entity;
    }


    public Optional<T> findById(int id) {
        T entity = entityManager.find(entityClass, id);
        return entity != null && !entity.isDeleted() ? Optional.of(entity) : Optional.empty();
    }



    public void softDeleteById(int id) {
        Optional<T> optionalEntity = findById(id);
        if (optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            entity.setDeleted(true);
            entityManager.merge(entity);
        }
    }

//    // Приватные методы для более сложных операций
//    protected T findSingleResult(String query, Object... params) {
//        var q = entityManager.createQuery(query, entityClass);
//        for (int i = 0; i < params.length; i++) {
//            q.setParameter(i + 1, params[i]);
//        }
//        return q.getSingleResult();
//    }
//
//    protected List<T> findResultList(String query, Object... params) {
//        var q = entityManager.createQuery(query, entityClass);
//        for (int i = 0; i < params.length; i++) {
//            q.setParameter(i + 1, params[i]);
//        }
//        return q.getResultList();
//    }
}
