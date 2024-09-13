package org.example.services;

import org.example.dto.BookingDto;
import org.example.entities.Booking;

public interface PaymentService {

    boolean processPayment(BookingDto booking, String paymentDetails);

    boolean initiatePayment(BookingDto booking, String paymentDetails);

    boolean confirmPayment(BookingDto booking, String paymentConfirmationDetails);
}