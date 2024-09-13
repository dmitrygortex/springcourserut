package org.example.repositories.impl;

import org.example.entities.Studio;
import org.example.repositories.StudioRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudioRepositoryImpl extends BaseRepositoryImpl<Studio> implements StudioRepository {

    public StudioRepositoryImpl() {
        super(Studio.class);
    }

    @Override
    public List<Studio> findStudiosByName(String name) {
        TypedQuery<Studio> query = entityManager.createQuery(
                "SELECT s FROM Studio s WHERE s.name = :name AND s.deleted = false",
                Studio.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Studio> findStudiosByAddress(String address) {
        TypedQuery<Studio> query = entityManager.createQuery(
                "SELECT s FROM Studio s WHERE s.address = :address AND s.deleted = false",
                Studio.class);
        query.setParameter("address", address);
        return query.getResultList();
    }

    @Override
    public List<Studio> findStudiosByRentFee(Integer rentFee) {
        TypedQuery<Studio> query = entityManager.createQuery(
                "SELECT s FROM Studio s WHERE s.rentFee = :rentFee AND s.deleted = false",
                Studio.class);
        query.setParameter("rentFee", rentFee);
        return query.getResultList();
    }

    @Override
    public List<Studio> findAllStudios() {
        TypedQuery<Studio> query = entityManager.createQuery(
                "SELECT s FROM Studio s WHERE s.deleted = false",
                Studio.class);
        return query.getResultList();
    }
}
