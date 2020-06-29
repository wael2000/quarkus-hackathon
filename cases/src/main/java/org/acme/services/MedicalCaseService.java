package org.acme.services;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.lang.model.util.ElementScanner6;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.acme.model.MedicalCase;
import org.acme.model.Report;

@ApplicationScoped
public class MedicalCaseService {
    @Inject
    EntityManager em; 

    @Transactional 
    public MedicalCase createMedicalCase(MedicalCase medicalCase) {
        System.out.println(medicalCase.getPhysician());
        if(medicalCase.getReports()!=null)
            for (Report report  : medicalCase.getReports()) 
                report.setMedicalCase(medicalCase);
        em.persist(medicalCase);
        return medicalCase;
    }

    public MedicalCase[] getAll(){
        return em.createNamedQuery("Cases.findAll", MedicalCase.class)
                .getResultList().toArray(new MedicalCase[0]);
    }

    public MedicalCase[] getPhysicianCases(String physician){
        return em.createNamedQuery("Cases.findByPhysician", MedicalCase.class)
                  .setParameter("physician",physician)
                  .getResultList().toArray(new MedicalCase[0]);
    }

    public MedicalCase getMedicalCase(Integer id){
        return em.find(MedicalCase.class, id);
    }

    @Transactional
    public MedicalCase updateMedicalCase(Integer id, MedicalCase updatedMedicalCase){
        MedicalCase medicalCase = em.find(MedicalCase.class, id);
        if(medicalCase!=null){
            //medicalCase.setDescription(updatedMedicalCase.getDescription());
            em.merge(updatedMedicalCase);
            // logic to handle reports
            for (Report report  : medicalCase.getReports()) 
                report.setMedicalCase(medicalCase);
        }
        em.persist(medicalCase);
        return medicalCase;
    }

    @Transactional
    public MedicalCase deleteMedicalCase(Integer id){
        MedicalCase medicalCase = em.getReference(MedicalCase.class, id);
        if(medicalCase!=null){
            em.remove(medicalCase);
        }
        return medicalCase;
    }

}