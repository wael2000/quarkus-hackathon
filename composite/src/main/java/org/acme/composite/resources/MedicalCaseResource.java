package org.acme.composite.resources;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;
import org.acme.composite.service.PhysicianService;
import org.acme.composite.service.MedicalCaseService;
import org.acme.composite.service.ProcessService;
import org.acme.composite.model.PhysicianProfile;
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
        System.out.println(caseRequest);
        return savedMedicalCase;
        //return medicalCaseService.createCase(medicalCase);
    }
    
}