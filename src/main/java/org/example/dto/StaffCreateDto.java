package org.example.dto;

import java.time.LocalDate;

public class StaffCreateDto {
    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private LocalDate experienceStartDate;
    private int pricePerHour;

    public StaffCreateDto(){}

    public StaffCreateDto(int id, String firstName, String lastName, String role, LocalDate experienceStartDate, int pricePerHour) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.experienceStartDate = experienceStartDate;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getExperienceStartDate() {
        return experienceStartDate;
    }

    public void setExperienceStartDate(LocalDate experienceStartDate) {
        this.experienceStartDate = experienceStartDate;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "StaffDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", experienceStartDate=" + experienceStartDate +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
