package com.tma.traininginformationservice.traininginformationservice.trainingentity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Response {
    private TrainingEntity courseDetails;
    private List<TrainerEntity> availableTrainerDetails;

    public TrainingEntity getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(TrainingEntity courseDetails) {
        this.courseDetails = courseDetails;
    }

    public List<TrainerEntity> getAvailableTrainerDetails() {
        return availableTrainerDetails;
    }

    public void setAvailableTrainerDetails(List<TrainerEntity> availableTrainerDetails) {
        this.availableTrainerDetails = availableTrainerDetails;
    }


}
