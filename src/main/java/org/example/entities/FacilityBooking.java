package org.example.entities;

import jakarta.persistence.Column;

public class FacilityBooking extends BaseEntity {

    private String facilityID;
    private String bookingID;
    private int quantity;

    @Column(name = "facilityID")
    public String getFacilityID() {
        return facilityID;
    }

    @Column(name = "bookingID")
    public String getBookingID() {
        return bookingID;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
