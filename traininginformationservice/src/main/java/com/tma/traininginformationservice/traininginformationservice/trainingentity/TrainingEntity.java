package com.tma.traininginformationservice.traininginformationservice.trainingentity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
@Entity
public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    @ElementCollection
    private List<String > skills;
    private  String duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private String studentType;
    private int numberOfBatches;
    private int numberOfStudentsPerBatch;
    private int budget;
    private String poc;
    private String organizationName;
    private String tableOfContents;
//    @Enumerated(EnumType.STRING)
    private String status;
    private String vendorId;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public long getId() {
        return id;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getDuration() {
        return duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }



    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(int numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
    }

    public int getNumberOfStudentsPerBatch() {
        return numberOfStudentsPerBatch;
    }

    public void setNumberOfStudentsPerBatch(int numberOfStudentsPerBatch) {
        this.numberOfStudentsPerBatch = numberOfStudentsPerBatch;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }
    public String getStatus() {
        return this.status;
    }


    public String getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(String tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

//    public void setAvailableTrainerDetails(List<TrainerEntity> availableTrainerDetails) {
//        this.availableTrainerDetails = availableTrainerDetails;
//    }

    public String getStudentType() {
        return studentType;
    }

//    public List<TrainerEntity> getAvailableTrainerDetails() {
//        return availableTrainerDetails;
//    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    @PrePersist
    @PreUpdate
    public void setDuration(){
        Period duration1=Period.between(this.startDate,this.endDate);
        this.duration=duration1.getYears()+"Years"+duration1.getMonths()+"Months"+ duration1.getDays()+"Days";
        if(LocalDate.now().isBefore(this.startDate)){
            this.status="UPCOMING";
        }
        if(LocalDate.now().isAfter(this.endDate)){
            this.status="COMPLETED";
        }
        if(!LocalDate.now().isBefore(this.startDate) && !LocalDate.now().isAfter(this.endDate)){
            this.status="INPROGRESS";
        }
    }
}
