package org.example.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    protected int id;
    protected boolean deleted;

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
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}



