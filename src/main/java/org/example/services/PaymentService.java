package org.example.services;

import org.example.entities.Booking;

public interface PaymentService {

    boolean processPayment(Booking booking, String paymentDetails);

    boolean initiatePayment(Booking booking, String paymentDetails);

    boolean confirmPayment(Booking booking, String paymentConfirmationDetails);
}