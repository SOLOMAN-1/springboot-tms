package com.training.vendorinformation.VendorInformation.entity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ResponseFromTraining {
    private TrainingEntity courseDetails;

    public List<TrainerEntity> getAvailableTrainerDetails() {
        return availableTrainerDetails;
    }

    public void setAvailableTrainerDetails(List<TrainerEntity> availableTrainerDetails) {
        this.availableTrainerDetails = availableTrainerDetails;
    }

    public TrainingEntity getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(TrainingEntity courseDetails) {
        this.courseDetails = courseDetails;
    }

    private List<TrainerEntity> availableTrainerDetails;
}
