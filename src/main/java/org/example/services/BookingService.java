package org.example.services;

import org.example.dto.BookingDto;
import org.example.entities.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    boolean cancel(Integer bookingId);

    boolean updateBookingDates(Integer bookingId, LocalDateTime newStartDate, LocalDateTime newEndDate);

    List<BookingDto> getClientBookings(Integer clientId);

    List<BookingDto> getStudioBookings(Integer studioId);

    BookingDto getBookingById(Integer bookingId);

}



