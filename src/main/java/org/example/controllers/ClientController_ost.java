//package org.example.controllers;
//
//import org.example.entities.Booking;
//import org.example.entities.Client;
//import org.example.entities.Studio;
//import org.example.services.BookingDomainService;
//import org.example.services.BookingService;
//import org.example.services.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/client")
//public class ClientController_ost {
//
//    @Autowired
//    private BookingDomainService bookingDomainService;
//
//    @Autowired
//    private BookingService bookingService;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @GetMapping("/studios/search")
//    public ResponseEntity<List<Studio>> searchStudios(
//            @RequestParam LocalDateTime startBookingDate,
//            @RequestParam LocalDateTime endBookingDate,
//            @RequestParam(required = false) String address,
//            @RequestParam(required = false) Integer minRentFee,
//            @RequestParam(required = false) Integer maxRentFee,
//            @RequestParam(required = false) String equipmentType) {
//
//        List<Studio> availableStudios = bookingDomainService.searchAvailableStudios(
//                startBookingDate, endBookingDate, address, minRentFee, maxRentFee, equipmentType);
//        return ResponseEntity.ok(availableStudios);
//    }
//
//    @PostMapping("/studios/{studioId}/book")
//    public ResponseEntity<String> bookStudio(
//            @PathVariable int studioId,
//            @RequestParam int clientId,
//            @RequestParam int staffId,
//            @RequestParam LocalDateTime startBookingDate,
//            @RequestParam LocalDateTime endBookingDate,
//            @RequestParam String paymentDetails) {
//
//        boolean bookingSuccess = bookingDomainService.rentStudio(studioId, clientId, staffId, startBookingDate, endBookingDate, paymentDetails);
//        if (bookingSuccess) {
//            return ResponseEntity.ok("Studio successfully booked.");
//        } else {
//            return ResponseEntity.status(409).body("Studio is already booked or not available.");
//        }
//    }
//
//    @GetMapping("/bookings")
//    public ResponseEntity<List<Booking>> getClientBookings(@RequestParam int clientId) {
//        List<Booking> bookings = bookingService.getClientBookings(clientId);
//        return ResponseEntity.ok(bookings);
//    }
//
//    @DeleteMapping("/bookings/{bookingId}/cancel")
//    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
//        boolean cancelSuccess = bookingService.cancel(bookingId);
//        if (cancelSuccess) {
//            return ResponseEntity.ok("Booking successfully canceled.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to cancel the booking.");
//        }
//    }
//
//    @PutMapping("/bookings/{bookingId}/update")
//    public ResponseEntity<String> updateBooking(
//            @PathVariable int bookingId,
//            @RequestParam LocalDateTime newStartDate,
//            @RequestParam LocalDateTime newEndDate) {
//
//        boolean updateSuccess = bookingService.updateBookingDates(bookingId, newStartDate, newEndDate);
//        if (updateSuccess) {
//            return ResponseEntity.ok("Booking dates successfully updated.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to update the booking.");
//        }
//    }
//
//    @PostMapping("/bookings/{bookingId}/add-services")
//    public ResponseEntity<String> addServicesToBooking(
//            @PathVariable int bookingId,
//            @RequestParam String additionalServicesDetails) {
//
//        Booking booking = bookingService.getBookingById(bookingId);
//        if (booking != null) {
//            boolean paymentSuccess = paymentService.processPayment(booking, additionalServicesDetails);
//            if (paymentSuccess) {
//                return ResponseEntity.ok("Additional services added successfully.");
//            }
//        }
//        return ResponseEntity.status(409).body("Failed to add additional services.");
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addClient(@RequestBody Client client){
//        boolean addSuccess = ClientService.addClient(client);
//        if (addSuccess) {
//            return ResponseEntity.ok("Equipment successfully added.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to add equipment.");
//        }
//    }
//}
