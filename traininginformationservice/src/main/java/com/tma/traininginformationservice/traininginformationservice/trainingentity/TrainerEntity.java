package com.tma.traininginformationservice.traininginformationservice.trainingentity;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerEntity {
    private Long trainerId;
    private String trainerName;

    private List<String> skill;
    private int budget;
    private LocalDate availableFrom;
    private LocalDate availableTo;
//    private Availability availableStatus;

    private String phoneNumber;
    private  String email;
    private String status;
    public String getStatus() {
        return status;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public List<String> getSkill() {
        return skill;
    }

    public int getBudget() {
        return budget;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public String    getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getAvailableTo() {
        return availableTo;
    }
}
