package org.example.services;

import org.example.dto.EquipmentCreateDto;

public interface StudioDomainService {

    boolean addEquipment(EquipmentCreateDto equipmentCreateDto, int studioId);

    //можно попробовать добавить учет сотрудников прикрепляя каждого из сотрудников к студиям
    //(главное учесть что один может работать сразу на нескольких)
    //boolean addStaff(int staffId);
    //boolean removeStaff(int staffId);
}
