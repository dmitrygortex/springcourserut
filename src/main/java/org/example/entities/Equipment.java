package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Equipment")
public class Equipment extends BaseEntity{

//    private int equipmentID;
    private String name;
    private String type;
    private String brand;
    private String model;
    private Studio studio;


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getEquipmentID(){
//        return equipmentID;
//    }

    @Column(name = "name")
    public String getName(){
        return name;
    }

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
    @JoinColumn(name = "studioId", referencedColumnName = "id")
    public Studio getStudio() {
        return studio;
    }

//    private void setEquipmentID(int equipmentID) {
//        this.equipmentID = equipmentID;
//    }

    private void setName(String name) {
        this.name = name;
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
