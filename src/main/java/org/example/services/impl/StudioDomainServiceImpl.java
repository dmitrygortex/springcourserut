package org.example.services.impl;

import org.example.dto.EquipmentCreateDto;
import org.example.dto.StaffCreateDto;
import org.example.entities.Equipment;
import org.example.entities.Studio;
import org.example.repositories.impl.EquipmentRepositoryImpl;
import org.example.repositories.impl.StaffRepositoryImpl;
import org.example.repositories.impl.StudioRepositoryImpl;
import org.example.services.StaffService;
import org.example.services.StudioDomainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudioDomainServiceImpl implements StudioDomainService {

    @Autowired
    private EquipmentRepositoryImpl equipmentRepository;

    @Autowired
    private StudioServiceImpl studioService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addEquipment(EquipmentCreateDto equipmentCreateDto, int studioId) {
        // правильно ли использовать сервис с вервисе или можно только репозитории
        equipmentCreateDto.setStudioDto(studioService.getStudioById(studioId));
        equipmentRepository.save(modelMapper.map(equipmentCreateDto, Equipment.class));
        return true;
    }
}
