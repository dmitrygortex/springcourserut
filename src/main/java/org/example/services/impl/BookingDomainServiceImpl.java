package org.example.services.impl;

import org.example.entities.*;
import org.example.repositories.BookingRepository;
import org.example.repositories.ClientRepository;
import org.example.repositories.StaffRepository;
import org.example.repositories.StudioRepository;
import org.example.services.BookingDomainService;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BookingDomainServiceImpl implements BookingDomainService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StaffRepository staffRepository;


    @Override
    public List<Studio> searchAvailableStudios(LocalDateTime startBookingDate, LocalDateTime endBookingDate, String address,
                                               Integer minRentFee, Integer maxRentFee, String equipmentType) {
        return bookingRepository.findAvailableStudios(startBookingDate, endBookingDate, address, minRentFee, maxRentFee, equipmentType);
    }

    @Override
    @Transactional
    public boolean rentStudio(int studioId, int clientId, int staffId, LocalDateTime newStartDate, LocalDateTime newEndDate, String paymentDetails) {
        if (bookingRepository.isStudioBooked(studioId, newStartDate, newEndDate)) {
            return false;
        }

        Optional<Studio> studioOpt = studioRepository.findById(studioId);
        if (!studioOpt.isPresent()) {
            return false;
        }

        Optional<Client> clientOpt = clientRepository.findById(clientId);
        Optional<Staff> staffOpt = staffRepository.findById(staffId);

        if (clientOpt.isPresent() && staffOpt.isPresent()) {
            Booking newBooking = new Booking();
            newBooking.setStudio(studioOpt.get());
            newBooking.setClient(clientOpt.get());
            newBooking.setStaff(staffOpt.get());
            newBooking.setStartBookingDate(newStartDate);
            newBooking.setEndBookingDate(newEndDate);

            newBooking.setStatus(RentStatus.RESERVED);
            bookingRepository.save(newBooking);

            PaymentService payment = new PaymentServiceImpl();

            if (!payment.processPayment(newBooking, paymentDetails)) {
                newBooking.setStatus(RentStatus.UNRESERVED);
                bookingRepository.save(newBooking);
                return false;
            }

            newBooking.setStatus(RentStatus.RENTED);
            bookingRepository.save(newBooking);
            return true;
        }

        return false;
    }

}



