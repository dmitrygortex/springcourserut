package org.example.repositories.impl;

import org.example.entities.FacilityBooking;
import org.example.repositories.FacilityBookingRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class FacilityBookingRepositoryImpl extends BaseRepositoryImpl<FacilityBooking> implements FacilityBookingRepository {

    public FacilityBookingRepositoryImpl() {
        super(FacilityBooking.class);
    }

    @Override
    public List<FacilityBooking> findFacilityBookingsByFacilityId(Integer facilityId) {
        TypedQuery<FacilityBooking> query = entityManager.createQuery(
                "SELECT fb FROM FacilityBooking fb WHERE fb.facility.id = :facilityId AND fb.isDeleted = false",
                FacilityBooking.class);
        query.setParameter("facilityId", facilityId);
        return query.getResultList();
    }

    @Override
    public List<FacilityBooking> findFacilityBookingsByBookingId(Integer bookingId) {
        TypedQuery<FacilityBooking> query = entityManager.createQuery(
                "SELECT fb FROM FacilityBooking fb WHERE fb.booking.id = :bookingId AND fb.isDeleted = false",
                FacilityBooking.class);
        query.setParameter("bookingId", bookingId);
        return query.getResultList();
    }

    @Override
    public List<FacilityBooking> findAllFacilityBookings() {
        TypedQuery<FacilityBooking> query = entityManager.createQuery(
                "SELECT fb FROM FacilityBooking fb WHERE fb.isDeleted = false",
                FacilityBooking.class);
        return query.getResultList();
    }
}
