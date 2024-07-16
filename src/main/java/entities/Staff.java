package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Staff")
public class Staff extends BaseEntity{

//    private int staffID;
    private String firstName;
    private String lastName;
    private String role;
    private String experience;
    private int pricePerHour;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getStaffID() {
//        return staffID;
//    }

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

    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

//    public void setStaffID(int staffID) {
//        this.staffID = staffID;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
