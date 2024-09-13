package org.example.services;

import org.example.dto.StaffDto;
import org.example.entities.Staff;

import java.util.List;

public interface StaffService {

    boolean addStaff(StaffDto staff);

    void removeStaff(Integer staffId);

    Staff getStaffById(Integer staffId);

    void updateStaff(Staff staff);

    List<StaffDto> getAllStaff();

    Staff findStaffByPricePerHourRange(int minPrice, int maxPrice);
}
