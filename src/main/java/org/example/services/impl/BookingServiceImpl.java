package org.example.services.impl;

import org.example.entities.Booking;
import org.example.deprecated_repositories.BookingRepository;
import org.example.entities.RentStatus;
import org.example.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional
    public boolean cancel(Integer bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(RentStatus.CANCELLED);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateBookingDates(Integer bookingId, LocalDateTime newStartDate, LocalDateTime newEndDate) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStartBookingDate(newStartDate);
            booking.setEndBookingDate(newEndDate);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getClientBookings(Integer clientId) {
        return bookingRepository.findBookingsByClientId(clientId);
    }

    @Override
    public List<Booking> getStudioBookings(Integer studioId) {
        return bookingRepository.findBookingsByStudioId(studioId);
    }

    @Override
    public Booking getBookingById(Integer bookingId) {
        return bookingRepository.findBookingById(bookingId);
    }
}




