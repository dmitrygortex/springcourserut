package org.example.controllers;

import org.example.dto.BookingCreateDto;
import org.example.dto.BookingDto;
import org.example.dto.ClientDto;
import org.example.dto.StudioSearchDto;
import org.example.entities.Booking;
import org.example.entities.Client;
import org.example.services.BookingDomainService;
import org.example.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    BookingDomainService bookingDomainService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody BookingCreateDto bookingCreateDto){
        //продумать как можно payment initiate и complete подвязать
        return bookingDomainService.rentStudio(
                bookingCreateDto.getStudioDto().getId(),
                bookingCreateDto.getClientDto().getId(),
                bookingCreateDto.getStaffDto().getId(),
                bookingCreateDto.getStartBookingDate(),
                bookingCreateDto.getEndBookingDate(),
                "Some payment details (TODO)") ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancel(@PathVariable Integer bookingId){
        return bookingService.cancel(bookingId) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @PutMapping("/update/{bookingId}/{newStartBookingDate}/{newEndBookingDate}")
    public ResponseEntity<String> updateDates(@PathVariable Integer bookingId,
                                              @PathVariable LocalDateTime newStartBookingDate,
                                              @PathVariable LocalDateTime newEndBookingDate){
        //RequestParam не работает совместно с PathVariable почему то, попробовать все же исправить
        return bookingService.updateBookingDates(
                bookingId,
                newStartBookingDate,
                newEndBookingDate
        ) ?
        ResponseEntity.ok("COMPLETED") :
        ResponseEntity.status(500).body("FAILED");
    }
    @GetMapping("/find/{bookingId}")
    public BookingDto findById(@PathVariable Integer bookingId){
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/bookings/{clientId}")
    public ResponseEntity<List<BookingDto>> getClientBookings(@PathVariable int clientId) {
        List<BookingDto> bookings = bookingService.getClientBookings(clientId);
        return ResponseEntity.ok(bookings);
    }

}
