package org.example.services.impl;

import org.example.dto.BookingDto;
import org.example.dto.StudioSearchDto;
import org.example.entities.Booking;
import org.example.repositories.BookingRepository;
import org.example.entities.RentStatus;
import org.example.repositories.impl.BookingRepositoryImpl;
import org.example.repositories.impl.FacilityBookingRepositoryImpl;
import org.example.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepositoryImpl bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

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
            System.out.println(bookingOpt.get());
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

    @Override
    public List<BookingDto> getClientBookings(Integer clientId) {
        return bookingRepository.findBookingsByClientId(clientId).stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getStudioBookings(Integer studioId) {
        return bookingRepository.findBookingsByStudioId(studioId).stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Integer bookingId) {
        return modelMapper.map(bookingRepository.findBookingById(bookingId), BookingDto.class);
        //return bookingRepository.findBookingById(bookingId);
    }
}




