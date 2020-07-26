package org.acme.composite.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class PhysicianProfile {
    public String id;
    public String name;
    public LocalDate birthDate;
    public String qualifications;
    //public Status status;
    public List<String> education;
    public List<String> expertise;
    public List<String> experience;
    public List<String> speciality;
    public List<String> awards;
    public List<String> publications;
    public List<String> memberships;
    public Map address;
    public String image;

    public List<org.acme.model.MedicalCase> cases;
       
}