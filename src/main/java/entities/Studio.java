package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Studio")
public class Studio extends BaseEntity{

//    private int studioID;
    private String name;
    private String description;
    private int rentFee;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getStudioID() {
//        return studioID;
//    }

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

//    public void setStudioID(int studioID) {
//        this.studioID = studioID;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }
}
