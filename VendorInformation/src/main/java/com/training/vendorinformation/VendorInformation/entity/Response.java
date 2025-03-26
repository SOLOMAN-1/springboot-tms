package com.training.vendorinformation.VendorInformation.entity;


import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Response {
    private VendorEntity vendorDetails;
   private ResponseFromTraining allTrainingDetails;


    public VendorEntity getVendorDetails() {
        return vendorDetails;
    }

    public void setVendorDetails(VendorEntity vendorDetails) {
        this.vendorDetails = vendorDetails;
    }


    public ResponseFromTraining getAllTrainingDetails() {
        return allTrainingDetails;
    }

    public void setAllTrainingDetails(ResponseFromTraining allTrainingDetails) {
        this.allTrainingDetails = allTrainingDetails;
    }
}
