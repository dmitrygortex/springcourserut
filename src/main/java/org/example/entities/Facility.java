package org.example.entities;

import jakarta.persistence.Column;

public class Facility extends BaseEntity {
    private String name;
    private String description;
    private int price;

    @Column(name = "name")
    public String getName() {return name; }

    @Column(name = "description")
    public String getDescription() {return description;}

    @Column(name = "price")
    public int getPrice() {return price;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
