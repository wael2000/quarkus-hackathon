package org.acme.composite.resources;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import org.acme.composite.service.PhysicianService;
import org.acme.composite.service.MedicalCaseService;
import org.acme.composite.service.ProcessService;
import org.acme.model.MedicalCase;
import org.acme.kogito.model.Request;
import org.acme.composite.model.CaseRequest;



@Path("/cases")
public class MedicalCaseResource {
    @Inject
    @RestClient
    PhysicianService physicianService;

    @Inject
    @RestClient
    MedicalCaseService medicalCaseService;

    @Inject
    @RestClient
    ProcessService processService;



    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalCase> getCases(){
        return medicalCaseService.getcases();
    }

    @GET
    @Path("/process/{id}")
    @Produces("application/json")
    public CaseRequest getProcess(@PathParam String id){
        CaseRequest request =  processService.getProcess(id);
        request.tasks = processService.getTasks(id);
        return request;
    }

    @GET
    @Path("/process/{id}/tasks")
    @Produces("application/json")
    public Map<String,String> getTasks(@PathParam String id){
        return processService.getTasks(id);
    }
    
    @GET
    @Path("/my")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalCase> myCases(){
        return medicalCaseService.myCases("alice");
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase createCase(MedicalCase medicalCase){
        MedicalCase savedMedicalCase = medicalCaseService.createCase(medicalCase);
        CaseRequest caseRequest = new CaseRequest();
        Request request = new Request();
        request.setPhysician(savedMedicalCase.getPhysician());
        request.setId(savedMedicalCase.getId());
        caseRequest.request = request;
        caseRequest = processService.startProcess(caseRequest);
        savedMedicalCase.setProcessId(caseRequest.id);
        medicalCaseService.updateCase(savedMedicalCase.getId(),savedMedicalCase);
        return savedMedicalCase;
        //return medicalCaseService.createCase(medicalCase);
    }
    
}