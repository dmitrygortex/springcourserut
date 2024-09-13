package org.example.repositories.impl;

import org.example.entities.Staff;
import org.example.repositories.StaffRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class StaffRepositoryImpl extends BaseRepositoryImpl<Staff> implements StaffRepository {

    public StaffRepositoryImpl() {
        super(Staff.class);
    }

    @Override
    public List<Staff> findStaffByExperienceRange(Integer minExperience, Integer maxExperience) {
        TypedQuery<Staff> query = entityManager.createQuery(
                "SELECT s FROM Staff s WHERE YEAR(CURRENT_DATE) - YEAR(s.experienceStartDate) BETWEEN :minExperience AND :maxExperience AND s.deleted = false",
                Staff.class);
        query.setParameter("minExperience", minExperience);
        query.setParameter("maxExperience", maxExperience);
        return query.getResultList();
    }

    @Override
    public List<Staff> findStaffByRole(String role) {
        TypedQuery<Staff> query = entityManager.createQuery(
                "SELECT s FROM Staff s WHERE s.role = :role AND s.deleted = false",
                Staff.class);
        query.setParameter("role", role);
        return query.getResultList();
    }

    @Override
    public List<Staff> findStaffByPriceRange(Integer minPrice, Integer maxPrice) {
        TypedQuery<Staff> query = entityManager.createQuery(
                "SELECT s FROM Staff s WHERE s.pricePerHour BETWEEN :minPrice AND :maxPrice AND s.deleted = false",
                Staff.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }

    @Override
    public List<Staff> findStaffByBookingId(Integer bookingId) {
        TypedQuery<Staff> query = entityManager.createQuery(
                "SELECT s FROM Staff s JOIN Booking b ON s.id = b.staff.id WHERE b.id = :bookingId AND s.deleted = false",
                Staff.class);
        query.setParameter("bookingId", bookingId);
        return query.getResultList();
    }

    @Override
    public List<Staff> findAllStaff() {
        TypedQuery<Staff> query = entityManager.createQuery(
                "SELECT s FROM Staff s WHERE s.deleted = false",
                Staff.class);
        return query.getResultList();
    }
}
