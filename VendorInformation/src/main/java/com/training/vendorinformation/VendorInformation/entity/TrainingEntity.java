package com.training.vendorinformation.VendorInformation.entity;


import java.time.LocalDate;
import java.util.List;

public class TrainingEntity {

    private  long id;
    private String name;

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
    private long vendorId;
    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(String tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
