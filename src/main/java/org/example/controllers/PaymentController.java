package org.example.controllers;

import org.example.entities.Booking;
import org.example.services.BookingService;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(
            @RequestParam int bookingId,
            @RequestParam String paymentDetails) {

        Booking booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            boolean initiateSuccess = paymentService.initiatePayment(booking, paymentDetails);
            if (initiateSuccess) {
                return ResponseEntity.ok("Payment initiated successfully.");
            }
        }
        return ResponseEntity.status(409).body("Failed to initiate payment.");
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(
            @RequestParam int bookingId,
            @RequestParam String paymentConfirmationDetails) {

        Booking booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            boolean confirmSuccess = paymentService.confirmPayment(booking, paymentConfirmationDetails);
            if (confirmSuccess) {
                return ResponseEntity.ok("Payment confirmed successfully.");
            }
        }
        return ResponseEntity.status(409).body("Failed to confirm payment.");
    }
}
