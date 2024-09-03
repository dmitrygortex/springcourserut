package org.example.services.impl;

import org.example.entities.Staff;
import org.example.repositories.StaffRepository;
import org.example.repositories.impl.StaffRepositoryImpl;
import org.example.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepositoryImpl staffRepository;

    @Override
    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void removeStaff(Integer staffId) {
        staffRepository.softDeleteById(staffId);
    }

    @Override
    public Staff getStaffById(Integer staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        return staff.orElse(null);
    }

    @Override
    public void updateStaff(Staff staff) {
        // Update logic is essentially the same as adding since `save` handles both creation and update
        staffRepository.save(staff);
    }

    @Override
    public Iterable<Staff> getAllStaff() {
        return staffRepository.findAllStaff();
    }

    @Override
    public Staff findStaffByPricePerHourRange(int minPrice, int maxPrice) {
        List<Staff> staffList = staffRepository.findStaffByPriceRange(minPrice, maxPrice);
        return staffList.isEmpty() ? null : staffList.get(0);
    }
}
