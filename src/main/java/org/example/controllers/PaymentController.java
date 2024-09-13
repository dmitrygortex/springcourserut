package org.example.controllers;

import org.example.dto.BookingDto;
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

        BookingDto booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            boolean initiateSuccess = paymentService.initiatePayment(booking, paymentDetails);
            if (initiateSuccess) {
                return ResponseEntity.ok("INITIATED");
            }
        }
        return ResponseEntity.status(500).body("FAILED");
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(
            @RequestParam int bookingId,
            @RequestParam String paymentConfirmationDetails) {

        BookingDto booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            boolean confirmSuccess = paymentService.confirmPayment(booking, paymentConfirmationDetails);
            if (confirmSuccess) {
                return ResponseEntity.ok("CONFIRMED");
            }
        }
        return ResponseEntity.status(409).body("FAILED");
    }
}
