package org.example.repositories;

import org.example.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StaffRepository{

    List<Staff> findStaffByExperienceRange(Integer minExperience, Integer maxExperience);

    List<Staff> findStaffByRole(String role);

    List<Staff> findStaffByPriceRange(Integer minPrice, Integer maxPrice);

    List<Staff> findStaffByBookingId(Integer bookingId);

    List<Staff> findAllStaff();

}



