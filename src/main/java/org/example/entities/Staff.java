package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Staff")
public class Staff extends BaseEntity{


    private String firstName;
    private String lastName;
    private String role;
    private LocalDate experienceStartDate;
    private int pricePerHour;


    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "pricePerHour")
    public int getPricePerHour() {
        return pricePerHour;
    }

    @Column(name = "experienceStartDate")
    public LocalDate getExperienceStartDate() {
        return experienceStartDate;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExperienceStartDate(LocalDate experienceStartDate) {
        this.experienceStartDate = experienceStartDate;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
