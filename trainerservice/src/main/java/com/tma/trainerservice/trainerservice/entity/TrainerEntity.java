package com.tma.trainerservice.trainerservice.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String trainerName;
    @ElementCollection
    private List<String> skill;
    private int budget;
    private LocalDate availableFrom;
    private LocalDate availableTo;
    //    private Availability availableStatus;
    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Phone number should be valid.....")
    private String phoneNumber;
    @Email(message = "Email should be valid........")
    private  String email;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @Column(nullable = true)
    private Long trainingId;
    @Column(nullable  = true)
    private Long vendorId;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Availability getStatus() {
        return status;
    }

    public void setStatus(Availability status) {
        this.status = status;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDate getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalDate availableTo) {
        this.availableTo = availableTo;
    }

//    public Availability getAvailableStatus() {
//        return availableStatus;
//    }
//
//    public void setAvailableStatus(Availability availableStatus) {
//        this.availableStatus = availableStatus;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
