package com.tma.traininginformationservice.traininginformationservice.service;

import com.tma.traininginformationservice.traininginformationservice.repository.TrainingRepository;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.Response;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.TrainerEntity;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.TrainingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepo;
    @Autowired
    Response response;
  TrainingEntity trainingEntity = new TrainingEntity();
    @Autowired
    WebClient webClient;
    public String addTrainingDetails(TrainingEntity trainingEntity){
        trainingRepo.save(trainingEntity);
        webClient.post().
                uri("http://localhost:9999/add/vendor/{id}/{trainingId}",trainingEntity.getVendorId(),trainingEntity.getId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {})
                .block();
        return "Taining Information Saved Successfully and the trainig Id updated in vendor";

    }
    public Response trainerDetails(long id){
        TrainingEntity training= trainingRepo.findById(id).orElseGet(null);
        int budget=training.getBudget();
        System.out.println(budget);
        LocalDate startDate=training.getStartDate();
        System.out.println(startDate);
        LocalDate endDate=training.getEndDate();
        System.out.println(endDate);
        List<String>Sk=training.getSkills();
        String Skill=Sk.get(0);
        System.out.println(Skill);
        List<TrainerEntity>trainers=webClient.get().
                uri("http://localhost:8888/trainer/get/{budget}/{startDate}/{endDate}/{Skill}", budget, startDate, endDate, Skill)
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<List<TrainerEntity>>() {})
                        .block();

//        trainingEntity.setAvailableTrainerDetails(trainers);
//        System.out.println(trainingEntity.getAvailableTrainerDetails());
        ;

        trainingRepo.save(training);
//        TrainingEntity training2= trainingRepo.findById(id).orElseGet(null);
        response.setAvailableTrainerDetails(trainers);
        response.setCourseDetails(training);

        return response;
    }

}
