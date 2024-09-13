package org.example.dto;

import org.example.entities.Studio;

public class EquipmentCreateDto {
    private int id;
    private String type;
    private String brand;
    private String model;
    private StudioDto studioDto;

    public EquipmentCreateDto(){}
    public EquipmentCreateDto(int id, String type, String brand, String model, StudioDto studioDto) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.studioDto = studioDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public StudioDto getStudioDto() {
        return studioDto;
    }

    public void setStudioDto(StudioDto studioDto) {
        this.studioDto = studioDto;
    }

    @Override
    public String toString() {
        return "EquipmentDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", studioDto=" + studioDto +
                '}';
    }
}
