package org.example.repositories;

import org.example.entities.Booking;
import org.example.entities.Studio;

import java.time.LocalDateTime;
import java.util.List;


public interface BookingRepository {
    List<Studio> findAvailableStudios(LocalDateTime startBookingDate,
                                      LocalDateTime endBookingDate,
                                      String address,
                                      Integer minRentFee,
                                      Integer maxRentFee,
                                      String equipmentType);

    boolean isStudioBooked(Integer studioId, LocalDateTime startBookingDate, LocalDateTime endBookingDate);

    List<Booking> findBookingsByClientId(Integer clientId);

    List<Booking> findBookingsByStudioId(Integer studioId);

    Booking findBookingById(Integer id);

}


