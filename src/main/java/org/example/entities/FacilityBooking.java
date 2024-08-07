package org.example.entities;

import jakarta.persistence.*;

import java.awt.print.Book;

@Entity
@Table(name = "FacilityBooking")
public class FacilityBooking extends BaseEntity {

    private Facility facility;
    private Booking booking;
    private int quantity;


    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    public Facility getFacility() {
        return facility;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    public Booking getBooking() {
        return booking;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
