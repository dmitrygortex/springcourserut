package org.example.services;

import org.example.dto.EquipmentDto;
import org.example.entities.Equipment;

import java.util.List;

public interface EquipmentService {

    boolean addEquipment(EquipmentDto equipment);

    boolean removeEquipment(int equipmentId);

    Equipment getEquipmentById(int equipmentId);

    boolean updateEquipment(Equipment equipment);

    List<EquipmentDto> getAllEquipment();

    Equipment findEquipmentByType(String equipmentType);

    List<Equipment> findEquipmentByStudioId(int studioId);

    List<Equipment> findEquipmentByBrand(String brand);


}
