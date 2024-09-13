package org.example.controllers;

import org.example.dto.BookingDto;
import org.example.dto.ClientDto;
import org.example.dto.StudioDto;
import org.example.dto.StudioSearchDto;
import org.example.entities.Booking;
import org.example.entities.Client;
import org.example.entities.Studio;
import org.example.services.BookingDomainService;
import org.example.services.BookingService;
import org.example.services.ClientService;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private BookingDomainService bookingDomainService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody ClientDto clientDto){
        return clientService.addClient(clientDto) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @PostMapping("/find/{id}")
    public ClientDto findClientById(@PathVariable int id){
        return clientService.findClientById(id);
    }

    @PostMapping("/studios/{studioId}/book")
    public ResponseEntity<String> bookStudio(
            @PathVariable int studioId,
            @RequestParam int clientId,
            @RequestParam int staffId,
            @RequestParam LocalDateTime startBookingDate,
            @RequestParam LocalDateTime endBookingDate,
            @RequestParam String paymentDetails) {

        return bookingDomainService.rentStudio(
                studioId,
                clientId,
                staffId,
                startBookingDate,
                endBookingDate,
                paymentDetails
        ) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");

    }







//    @PostMapping("/bookings/{bookingId}/add-services")
//    public ResponseEntity<String> addServicesToBooking(
//            @PathVariable int bookingId,
//            @RequestParam String additionalServicesDetails) {
//
//        BookingDto booking = bookingService.getBookingById(bookingId);
//        if (booking != null) {
//            boolean paymentSuccess = paymentService.processPayment(booking, additionalServicesDetails);
//            if (paymentSuccess) {
//                return ResponseEntity.ok("COMPLETED");
//            }
//        }
//        return ResponseEntity.status(500).body("FAILED");
//    }
}
