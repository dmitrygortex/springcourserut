package org.example.services;

import org.example.entities.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    boolean cancel(Integer bookingId);

    boolean updateBookingDates(Integer bookingId, LocalDateTime newStartDate, LocalDateTime newEndDate);

    List<Booking> getClientBookings(Integer clientId);

    List<Booking> getStudioBookings(Integer studioId);

    Booking getBookingById(Integer bookingId);

}



