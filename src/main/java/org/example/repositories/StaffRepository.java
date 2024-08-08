package org.example.repositories;

import org.example.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    @Query("SELECT s FROM Staff s WHERE s.experienceStartDate >= :minExperience AND s.experienceStartDate <= :maxExperience")
    List<Staff> findStaffByExperienceRange(@Param("minExperience") Integer minExperience, @Param("maxExperience") Integer maxExperience);

    @Query("SELECT s FROM Staff s WHERE s.role LIKE %:role%")
    List<Staff> findStaffByRole(@Param("role") String role);

    @Query("SELECT s FROM Staff s WHERE s.pricePerHour >= :minPrice AND s.pricePerHour <= :maxPrice")
    List<Staff> findStaffByPriceRange(@Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);

    @Query("SELECT s FROM Staff s JOIN Booking b ON s.id = b.staff.id WHERE b.id = :bookingId")
    List<Staff> findStaffByBookingId(@Param("bookingId") Integer bookingId);

    @Query("SELECT s FROM Staff s")
    List<Staff> findAllStaff();

}



