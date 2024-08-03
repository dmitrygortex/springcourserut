package org.example.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    protected int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



