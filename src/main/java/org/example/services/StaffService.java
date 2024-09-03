package org.example.services;

import org.example.entities.Staff;

public interface StaffService {

    void addStaff(Staff staff);

    void removeStaff(Integer staffId);

    Staff getStaffById(Integer staffId);

    void updateStaff(Staff staff);

    Iterable<Staff> getAllStaff();

    Staff findStaffByPricePerHourRange(int minPrice, int maxPrice);
}
