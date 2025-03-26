package com.training.vendorinformation.VendorInformation.entity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ResponseAll {
    private VendorEntity vendorDetails;
    private List<ResponseFromTraining> allTrainingDetails;
    public List<ResponseFromTraining> getAllTrainingDetails() {
        return allTrainingDetails;
    }

    public void setAllTrainingDetails(List<ResponseFromTraining> allTrainingDetails) {
        this.allTrainingDetails = allTrainingDetails;
    }

    public VendorEntity getVendorDetails() {
        return vendorDetails;
    }

    public void setVendorDetails(VendorEntity vendorDetails) {
        this.vendorDetails = vendorDetails;
    }


}
