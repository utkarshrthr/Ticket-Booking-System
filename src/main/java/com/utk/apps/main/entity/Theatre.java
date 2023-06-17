package com.utk.apps.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "theatres")
public class Theatre extends EntityMaster {

    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> audis;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Auditorium> getAudis() {
        return audis;
    }

    public void setAudis(List<Auditorium> audis) {
        this.audis = audis;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
