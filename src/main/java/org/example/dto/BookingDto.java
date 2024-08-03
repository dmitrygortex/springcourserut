package org.example.dto;

import org.example.entities.RentStatus;

import java.time.LocalDateTime;

public class BookingDto {

    private RentStatus status;
    private LocalDateTime startBookingDate;
    private LocalDateTime endBookingDate;
    private int studioId;
    private int clientId;
    private int staffId;
    private String paymentDetails;

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
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

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}


