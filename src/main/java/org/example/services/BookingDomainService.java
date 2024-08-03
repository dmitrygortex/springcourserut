package org.example.services;

import org.example.entities.Studio;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingDomainService {

    List<Studio> searchAvailableStudios(LocalDateTime startBookingDate, LocalDateTime endBookingDate, String address,
                                        Integer minRentFee, Integer maxRentFee, String equipmentType);

    boolean rentStudio(int studioId, int clientId, int staffId, LocalDateTime newStartDate, LocalDateTime newEndDate, String paymentDetails);

}




