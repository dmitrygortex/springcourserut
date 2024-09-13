package org.example.services.impl;

import org.example.dto.StudioCreateDto;
import org.example.dto.StudioDto;
import org.example.entities.Equipment;
import org.example.entities.Studio;
import org.example.repositories.impl.EquipmentRepositoryImpl;
import org.example.repositories.impl.StudioRepositoryImpl;
import org.example.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repositories.StudioRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepositoryImpl studioRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public boolean addStudio(StudioCreateDto studioCreateDto) {
        studioRepository.save(modelMapper.map(studioCreateDto, Studio.class));
        return true;
    }

    @Override
    public boolean removeStudio(int studioId) {
        studioRepository.softDeleteById(studioId);
        return true;
    }

    @Override
    public StudioDto getStudioById(int studioId) {
        //добавить обработчик null через isPresent()
        return modelMapper.map(studioRepository.findById(studioId).get(), StudioDto.class);
    }

    @Override
    public boolean updateStudio(Studio studio) {
        studioRepository.save(studio);
        return true;
    }

    @Override
    public List<StudioDto> getAllStudio() {
        return studioRepository.findAllStudios().stream().map(studio -> modelMapper.map(studio, StudioDto.class)).collect(Collectors.toList());
    }


}
