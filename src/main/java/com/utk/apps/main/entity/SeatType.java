package com.utk.apps.main.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seat_types")
public class SeatType extends EntityMaster {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
