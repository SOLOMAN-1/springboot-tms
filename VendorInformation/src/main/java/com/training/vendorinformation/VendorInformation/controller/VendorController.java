package com.training.vendorinformation.VendorInformation.controller;

import com.training.vendorinformation.VendorInformation.entity.*;
import com.training.vendorinformation.VendorInformation.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class VendorController {
    @Autowired
    VendorService vendorService;
    @PostMapping("/addVendor")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addCourse(@RequestBody VendorEntity vendorEntity){
        return vendorService.addVendor(vendorEntity);
    }
    @GetMapping("/get/vendordetails/{id}/{id2}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Response getTrainingAndTrainerDetails(@PathVariable long id,
                                                 @PathVariable long id2)
    {
        return vendorService.getVendorDetails(id,id2);
    }
    @GetMapping("/get/vendordetails/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseAll getTrainingAndTrainerDetails(@PathVariable long id)
    {
        return vendorService.getAllVendorDetails(id);
    }
    @PostMapping("/add/vendor/{id}/{trainingId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public VendorEntity updateTrainingId(@PathVariable long id,@PathVariable long trainingId)
    {
        return vendorService.updateTrainingId(id,trainingId);
    }
    @PostMapping("/select/{vendorId}/{trainingId}/{trainerId}/")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TrainerEntity makeSelect(@PathVariable long vendorId, @PathVariable long trainingId, @PathVariable long trainerId){
        return vendorService.makeSelect(vendorId,trainingId,trainerId);
    }
}
