package com.training.vendorinformation.VendorInformation.services;

import com.training.vendorinformation.VendorInformation.VendorInformationApplication;
import com.training.vendorinformation.VendorInformation.entity.*;
import com.training.vendorinformation.VendorInformation.vendorrepository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    VendorRepository vendorrepo;
    @Autowired
    Response response;
    @Autowired
     WebClient webClient;
    @Autowired
    ResponseAll responseAll;
    public String addVendor(VendorEntity vendor) {
        vendorrepo.save(vendor);
        return "Vendor Added Successfully";
    }

    public Response getVendorDetails(Long id,Long id2) {
        VendorEntity vendor = vendorrepo.findById(id).orElseGet(null);

        response.setVendorDetails(vendor);

            ResponseFromTraining trainingInformation = webClient.get().
                    uri("http://localhost:8088/get/trainingdetails/{id2}", id2).retrieve()
                    .bodyToMono(new ParameterizedTypeReference<ResponseFromTraining>() {
                    }).block();
            response.setAllTrainingDetails(trainingInformation);

        return response;
    }
    public ResponseAll getAllVendorDetails(Long id) {
        VendorEntity vendor = vendorrepo.findById(id).orElseGet(null);
        List<Long>id1=vendor.getTrainingId();
        System.out.println(id1.toString());
        responseAll.setVendorDetails(vendor);
        List<ResponseFromTraining>allDetails=new ArrayList<>();
        for(Long id3:id1) {
            ResponseFromTraining trainingInformation = webClient.get().
                    uri("http://localhost:8088/get/trainingdetails/{id3}", id3).retrieve()
                    .bodyToMono(new ParameterizedTypeReference<ResponseFromTraining>() {
                    }).block();

            allDetails.add(trainingInformation);

        }
        responseAll.setAllTrainingDetails(allDetails);
        return responseAll;
    }


    public VendorEntity updateTrainingId(Long id,Long trainingId) {
        VendorEntity vendor=vendorrepo.findById(id).orElseGet(null);

        List<Long>updatedTrainingId=vendor.getTrainingId();
        updatedTrainingId.add(trainingId);
        vendor.setTrainingId(updatedTrainingId);
        vendorrepo.saveAndFlush(vendor);
        return vendor;
    }

    public TrainerEntity makeSelect(long vendorId, long trainingId, long trainerId) {
        TrainerEntity trainerSelected=webClient.post().
                 uri("http://localhost:8888/trainer/add/select/{vendorId}/{trainingId}/{trainerId}",vendorId,trainingId,trainerId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TrainerEntity>(){}).block();
        return trainerSelected;
    }
}

