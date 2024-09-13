package org.example.services.impl;

import org.example.dto.EquipmentDto;
import org.example.entities.Equipment;
import org.example.repositories.EquipmentRepository;
import org.example.repositories.impl.EquipmentRepositoryImpl;
import org.example.services.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepositoryImpl equipmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addEquipment(EquipmentDto equipmentDto) {
        equipmentRepository.save(modelMapper.map(equipmentDto, Equipment.class));
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
    public List<EquipmentDto> getAllEquipment() {
        return equipmentRepository.findAllEquipment().stream().map(equipment -> modelMapper.map(equipment, EquipmentDto.class)).collect(Collectors.toList());
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
