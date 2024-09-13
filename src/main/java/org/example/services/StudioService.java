package org.example.services;

import org.example.dto.StudioCreateDto;
import org.example.dto.StudioDto;
import org.example.entities.Equipment;
import org.example.entities.Studio;

import java.util.List;

public interface StudioService {

    boolean addStudio(StudioCreateDto studio);

    boolean removeStudio(int studioId);

    StudioDto getStudioById(int studioId);

    boolean updateStudio(Studio studio);

    List<StudioDto> getAllStudio();


}
