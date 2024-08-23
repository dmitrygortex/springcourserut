package org.example.repositories.impl;

import org.example.entities.Equipment;
import org.example.repositories.EquipmentRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class EquipmentRepositoryImpl extends BaseRepositoryImpl<Equipment> implements EquipmentRepository {

    public EquipmentRepositoryImpl() {
        super(Equipment.class);
    }

    @Override
    public List<Equipment> findEquipmentByType(String type) {
        TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.type = :type AND e.isDeleted = false", Equipment.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Equipment> findEquipmentByStudioId(Integer studioId) {
        TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.studio.id = :studioId AND e.isDeleted = false", Equipment.class);
        query.setParameter("studioId", studioId);
        return query.getResultList();
    }

    @Override
    public List<Equipment> findEquipmentByBrand(String brand) {
        TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.brand = :brand AND e.isDeleted = false", Equipment.class);
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public List<Equipment> findAllEquipment() {
        TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.isDeleted = false", Equipment.class);
        return query.getResultList();
    }
}
