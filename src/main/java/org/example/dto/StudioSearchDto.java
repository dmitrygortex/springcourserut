package org.example.dto;

public class StudioSearchDto {
    private int id;
    private String name;
    private String description;
    private int rentFee;
    private String address;


    public StudioSearchDto(){}

    public StudioSearchDto(int id, String name, String description, int rentFee, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rentFee = rentFee;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRentFee() {
        return rentFee;
    }

    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudioDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rentFee=" + rentFee +
                ", address='" + address + '\'' +
                '}';
    }
}
