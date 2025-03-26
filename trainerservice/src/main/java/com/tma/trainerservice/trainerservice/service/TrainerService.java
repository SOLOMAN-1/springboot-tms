package com.tma.trainerservice.trainerservice.service;

import com.tma.trainerservice.trainerservice.entity.Availability;
import com.tma.trainerservice.trainerservice.entity.TrainerEntity;
import com.tma.trainerservice.trainerservice.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepo;
    public List<TrainerEntity> getAllTrainers(int budget, LocalDate startdate,LocalDate enddate,String skill) {
        List<TrainerEntity> allTrainers=trainerRepo.findAll();
        List<TrainerEntity> availableTrainers=new ArrayList<>();
        for (TrainerEntity trainer : allTrainers) {
            System.out.println(trainer.getSkill());
            int budget1 = trainer.getBudget();
            Availability status=trainer.getStatus();
            long id=trainer.getTrainerId();
            List<String> skills = trainerRepo.findSkillsByTrainerId(id);

            if (budget <= budget1 &&
                    startdate.isAfter(trainer.getAvailableFrom()) &&
                    startdate.isBefore(trainer.getAvailableTo()) &&
                    enddate.isBefore(trainer.getAvailableTo())&&status!=Availability.SELECTED) {
                for (String Skill : skills) {

                    if (Skill.equals(skill)) {

                        availableTrainers.add(trainer);
                    }
                }
            }
        }
        return availableTrainers;
    }
    public String addTrainers(TrainerEntity trainer){

        trainerRepo.save(trainer);
        return "Trainers added successfully.";
    }
    public TrainerEntity addSelection(long vendorId,long trainingId,long trainerId){
        TrainerEntity trainer=trainerRepo.findById(trainerId).orElseGet(null);
        List<TrainerEntity>allTrainers=trainerRepo.findAll();
        for(TrainerEntity trainer2:allTrainers){
            if(trainer2.getTrainerId()!=trainerId && trainer2.getStatus()!=Availability.SELECTED){
                trainer2.setStatus(Availability.NOT_SELECTED);
                trainerRepo.save(trainer2);
            }
        }
        trainer.setStatus(Availability.SELECTED);
        trainer.setTrainingId(trainingId);
        trainer.setVendorId(vendorId);
        trainerRepo.save(trainer);
        return trainer;
    }


    public List<TrainerEntity> getSelectedTrainers() {
        List<TrainerEntity>allTrainers=trainerRepo.findAll();
        List<TrainerEntity>selectedTrainers=new ArrayList<>();
        for (TrainerEntity trainer:allTrainers){
            if(trainer.getStatus()!=Availability.NOT_SELECTED){
                selectedTrainers.add(trainer);
            }
        }
        return selectedTrainers;
    }
}