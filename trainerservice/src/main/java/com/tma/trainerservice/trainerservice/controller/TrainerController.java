package com.tma.trainerservice.trainerservice.controller;

import com.tma.trainerservice.trainerservice.entity.TrainerEntity;
import com.tma.trainerservice.trainerservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    @GetMapping("/get/{budget}/{startdate}/{enddate}/{skill}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TrainerEntity> getAllTrainers(@PathVariable int budget,@PathVariable LocalDate startdate,@PathVariable LocalDate enddate,@PathVariable String skill) {
            return trainerService.getAllTrainers(budget,startdate,enddate,skill);
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addTrainers(@RequestBody TrainerEntity trainer){

        return trainerService.addTrainers(trainer);
    }
    @PostMapping("/add/select/{vendorId}/{trainingId}/{trainerId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TrainerEntity  addSelection(@PathVariable long vendorId,
                                @PathVariable long trainingId,
                                @PathVariable long trainerId){
        return  trainerService.addSelection(vendorId,trainerId,trainerId);
    }
    @GetMapping("/get/selectedtrainers")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TrainerEntity> getSelectedTrainers(){
        return trainerService.getSelectedTrainers();
    }

}


