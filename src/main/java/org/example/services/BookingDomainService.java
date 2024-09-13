package org.example.services;

import org.example.dto.StudioDto;
import org.example.dto.StudioSearchDto;
import org.example.entities.Studio;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingDomainService {

    List<StudioSearchDto> searchAvailableStudios(LocalDateTime startBookingDate, LocalDateTime endBookingDate, String address,
                                                 Integer minRentFee, Integer maxRentFee, String equipmentType);

    boolean rentStudio(int studioId, int clientId, int staffId, LocalDateTime newStartDate, LocalDateTime newEndDate, String paymentDetails);

}




