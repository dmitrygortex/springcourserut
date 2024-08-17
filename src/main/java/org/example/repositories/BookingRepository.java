package org.example.repositories;

import org.example.entities.Booking;
import org.example.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


public interface BookingRepository {
    List<Studio> findAvailableStudios(LocalDateTime startBookingDate, LocalDateTime endBookingDate, String address, Integer minRentFee, Integer maxRentFee, String equipmentType);

    boolean isStudioBooked(Integer studioId, LocalDateTime startBookingDate, LocalDateTime endBookingDate);

    List<Booking> findBookingsByClientId(Integer clientId);

    List<Booking> findBookingsByStudioId(Integer studioId);

    Booking findBookingById();

}


