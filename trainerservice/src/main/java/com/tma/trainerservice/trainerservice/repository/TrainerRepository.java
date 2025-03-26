package com.tma.trainerservice.trainerservice.repository;

import com.tma.trainerservice.trainerservice.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {
    @Query("SELECT t.skill FROM TrainerEntity t WHERE t.trainerId = :trainerId")
    List<String> findSkillsByTrainerId(@Param("trainerId") Long trainerId);
}
