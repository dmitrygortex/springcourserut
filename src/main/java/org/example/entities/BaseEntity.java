package org.example.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    protected int id;
    protected boolean isDeleted = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }
}



