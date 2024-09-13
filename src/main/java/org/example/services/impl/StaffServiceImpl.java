package org.example.services.impl;

import org.example.dto.StaffDto;
import org.example.dto.StudioSearchDto;
import org.example.entities.Staff;
import org.example.repositories.StaffRepository;
import org.example.repositories.impl.StaffRepositoryImpl;
import org.example.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepositoryImpl staffRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addStaff(StaffDto staffDto) {
        staffRepository.save(modelMapper.map(staffDto, Staff.class));
        return true;
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
        staffRepository.save(staff);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        return staffRepository.findAllStaff().stream().map(staff -> modelMapper.map(staff,StaffDto.class)).collect(Collectors.toList());
    }

    @Override
    public Staff findStaffByPricePerHourRange(int minPrice, int maxPrice) {
        List<Staff> staffList = staffRepository.findStaffByPriceRange(minPrice, maxPrice);
        return staffList.isEmpty() ? null : staffList.get(0);
    }
}
