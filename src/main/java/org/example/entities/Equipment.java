package org.example.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Equipment")
public class Equipment extends BaseEntity{

    private String type;
    private String brand;
    private String model;
    private Studio studio;


    @Column(name = "type")
    public String getType(){
        return type;
    }

    @Column(name = "brand")
    public String getBrand(){
        return brand;
    }

    @Column(name = "model")
    public String getModel(){
        return model;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "id")
    public Studio getStudio() {
        return studio;
    }


    private void setType(String type) {
        this.type = type;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setStudio(Studio studio) {
        this.studio = studio;
    }
}
