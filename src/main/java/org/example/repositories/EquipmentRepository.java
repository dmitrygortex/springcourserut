package org.example.repositories;

import org.example.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface EquipmentRepository {

    List<Equipment> findEquipmentByType(String type);

    List<Equipment> findEquipmentByStudioId(Integer studioId);

    List<Equipment> findEquipmentByBrand(String brand);

    List<Equipment> findAllEquipment();

}

