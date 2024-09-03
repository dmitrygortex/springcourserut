package org.example.services.impl;

import org.example.entities.Equipment;
import org.example.repositories.EquipmentRepository;
import org.example.repositories.impl.EquipmentRepositoryImpl;
import org.example.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepositoryImpl equipmentRepository;

    @Override
    public boolean addEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
        return true;
    }

    @Override
    public boolean removeEquipment(int equipmentId) {
        equipmentRepository.softDeleteById(equipmentId);
        return true;
    }

    @Override
    public Equipment getEquipmentById(int equipmentId) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        if (!optionalEquipment.isPresent()) {
            return null;
        }
        return optionalEquipment.get();
    }

    @Override
    public boolean updateEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
        return true;
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAllEquipment();
    }

    @Override
    public Equipment findEquipmentByType(String equipmentType) {
        List<Equipment> equipmentList = equipmentRepository.findEquipmentByType(equipmentType);
        return equipmentList.isEmpty() ? null : equipmentList.get(0);
    }

    @Override
    public List<Equipment> findEquipmentByStudioId(int studioId) {
        return equipmentRepository.findEquipmentByStudioId(studioId);
    }

    @Override
    public List<Equipment> findEquipmentByBrand(String brand) {
        return equipmentRepository.findEquipmentByBrand(brand);
    }
}
