package com.tma.traininginformationservice.traininginformationservice.repository;

import com.tma.traininginformationservice.traininginformationservice.trainingentity.TrainerEntity;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository  extends JpaRepository<TrainingEntity,Long>{


}


