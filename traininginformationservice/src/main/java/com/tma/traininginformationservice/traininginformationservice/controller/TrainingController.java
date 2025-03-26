package com.tma.traininginformationservice.traininginformationservice.controller;

import com.tma.traininginformationservice.traininginformationservice.repository.TrainingRepository;
import com.tma.traininginformationservice.traininginformationservice.service.TrainingService;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.Response;
import com.tma.traininginformationservice.traininginformationservice.trainingentity.TrainingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class TrainingController {
    @Autowired
    TrainingService trainingService;
    @PostMapping("/addCourse")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addCourse(@RequestBody TrainingEntity trainigEntity){
        return trainingService.addTrainingDetails(trainigEntity);
    }
    @GetMapping("/get/trainingdetails/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Response getTrainingAndTrainerDetails(@PathVariable long id)
                                                       {
        return trainingService.trainerDetails(id);
    }

}
