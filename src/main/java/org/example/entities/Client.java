package org.example.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Client")
public class Client extends BaseEntity{


    private String firstName;
    private String lastName;
    private String hashOfPassword;
    private String phoneNumber;
    private String email;


    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "hashOfPassword")
    public String getHashOfPassword() {
        return hashOfPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHashOfPassword(String hashOfPassword) {
        this.hashOfPassword = hashOfPassword;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
