package org.example.services;

import org.example.entities.Equipment;

import java.util.List;

public interface EquipmentService {

    boolean addEquipment(Equipment equipment);

    boolean removeEquipment(int equipmentId);

    Equipment getEquipmentById(int equipmentId);

    boolean updateEquipment(Equipment equipment);

    List<Equipment> getAllEquipment();

    Equipment findEquipmentByType(String equipmentType);

    List<Equipment> findEquipmentByStudioId(int studioId);

    List<Equipment> findEquipmentByBrand(String brand);
}
