package org.acme.model;


import java.util.Date;
import java.util.List;

public class MedicalCase {

    private Integer id;
    private String description;
    private String symptoms;
    private String allergies;
    private Date date;
    private String patientName;
    private String patientDOB;
    private String patientGender;
    private String patientNationality;

    private String physician;

    private String postDICOMURL;
    private String postDICOMPWD;

    private String username;

    private String processId;


    private List<Report> reports;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientNationality() {
        return patientNationality;
    }

    public void setPatientNationality(String patientNationality) {
        this.patientNationality = patientNationality;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }

    public String getPostDICOMURL() {
        return postDICOMURL;
    }

    public void setPostDICOMURL(String postDICOMURL) {
        this.postDICOMURL = postDICOMURL;
    }

    public String getPostDICOMPWD() {
        return postDICOMPWD;
    }

    public void setPostDICOMPWD(String postDICOMPWD) {
        this.postDICOMPWD = postDICOMPWD;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
    
}