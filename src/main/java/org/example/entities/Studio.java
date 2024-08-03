package org.example.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Studio")
public class Studio extends BaseEntity{

    private String name;
    private String description;
    private int rentFee;
    private String address;


    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "rentFee")
    public int getRentFee() {
        return rentFee;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
