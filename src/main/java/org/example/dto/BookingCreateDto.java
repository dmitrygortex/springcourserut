package org.example.dto;

import org.example.entities.Client;
import org.example.entities.RentStatus;
import org.example.entities.Staff;
import org.example.entities.Studio;

import java.time.LocalDateTime;

public class BookingCreateDto {
    private int id;
    private RentStatus status;
    private LocalDateTime startBookingDate;
    private LocalDateTime endBookingDate;
    private StudioDto studioDto;
    private ClientDto clientDto;
    private StaffDto staffDto;

    public BookingCreateDto(int id, RentStatus status, LocalDateTime startBookingDate,
                      LocalDateTime endBookingDate, StudioDto studioDto, ClientDto clientDto, StaffDto staffDto) {
        this.id = id;
        this.status = status;
        this.startBookingDate = startBookingDate;
        this.endBookingDate = endBookingDate;
        this.studioDto = studioDto;
        this.clientDto = clientDto;
        this.staffDto = staffDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RentStatus getStatus() {
        return status;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartBookingDate() {
        return startBookingDate;
    }

    public void setStartBookingDate(LocalDateTime startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public LocalDateTime getEndBookingDate() {
        return endBookingDate;
    }

    public void setEndBookingDate(LocalDateTime endBookingDate) {
        this.endBookingDate = endBookingDate;
    }

    public StudioDto getStudioDto() {
        return studioDto;
    }

    public void setStudioDto(StudioDto studioDto) {
        this.studioDto = studioDto;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public StaffDto getStaffDto() {
        return staffDto;
    }

    public void setStaffDto(StaffDto staffDto) {
        this.staffDto = staffDto;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", status=" + status +
                ", startBookingDate=" + startBookingDate +
                ", endBookingDate=" + endBookingDate +
                ", studioDto=" + studioDto +
                ", clientDto=" + clientDto +
                ", staffDto=" + staffDto +
                '}';
    }
}


