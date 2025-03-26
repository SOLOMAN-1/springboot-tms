package com.training.vendorinformation.VendorInformation.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class VendorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String organizationName;



    private String country;
    private String headQuarters;
    private String foundedYear;


    @ElementCollection
    private List<Long> trainingId;
    public List<Long> getTrainingId() {
        return trainingId;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTrainingId(List<Long> trainingId) {
        this.trainingId = trainingId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public long getId() {
        return id;
    }
}
