package org.example.repositories;

import org.example.entities.FacilityBooking;

import java.util.List;

public interface FacilityBookingRepository {

    List<FacilityBooking> findFacilityBookingsByFacilityId(Integer facilityId);

    List<FacilityBooking> findFacilityBookingsByBookingId(Integer bookingId);

    List<FacilityBooking> findAllFacilityBookings();
}
