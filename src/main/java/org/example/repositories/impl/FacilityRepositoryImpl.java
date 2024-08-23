package org.example.repositories.impl;

import org.example.entities.Facility;
import org.example.repositories.FacilityRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class FacilityRepositoryImpl extends BaseRepositoryImpl<Facility> implements FacilityRepository {

    public FacilityRepositoryImpl() {
        super(Facility.class);
    }

    @Override
    public List<Facility> findFacilitiesByName(String name) {
        TypedQuery<Facility> query = entityManager.createQuery(
                "SELECT f FROM Facility f WHERE f.name = :name AND f.isDeleted = false",
                Facility.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Facility> findFacilitiesByPriceRange(Integer minPrice, Integer maxPrice) {
        TypedQuery<Facility> query = entityManager.createQuery(
                "SELECT f FROM Facility f WHERE f.price BETWEEN :minPrice AND :maxPrice AND f.isDeleted = false",
                Facility.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }

    @Override
    public List<Facility> findAllFacilities() {
        TypedQuery<Facility> query = entityManager.createQuery(
                "SELECT f FROM Facility f WHERE f.isDeleted = false",
                Facility.class);
        return query.getResultList();
    }
}
