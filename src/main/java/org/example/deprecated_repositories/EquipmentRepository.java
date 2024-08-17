package org.example.deprecated_repositories;

import org.example.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    @Query("SELECT e FROM Equipment e WHERE e.type LIKE %:type%")
    List<Equipment> findEquipmentByType(@Param("type") String type);

    @Query("SELECT e FROM Equipment e WHERE e.studio.id = :studioId")
    List<Equipment> findEquipmentByStudioId(@Param("studioId") Integer studioId);

    @Query("SELECT e FROM Equipment e WHERE e.brand LIKE %:brand%")
    List<Equipment> findEquipmentByBrand(@Param("brand") String brand);

    @Query("SELECT e FROM Equipment e")
    List<Equipment> findAllEquipment();
}
