package org.acme.composite.service;

import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

import org.acme.model.MedicalCase;

@Path("/cases")
@RegisterRestClient
public interface MedicalCaseService {
    
    @GET
    @Path("/physician/{id}")
    @Produces("application/json")
    List<MedicalCase> getPhysicialCases(@PathParam String id);   
    
    
    @GET
    @Path("/")
    @Produces("application/json")
    List<MedicalCase> getcases();   

    @GET
    @Path("/my/{username}")
    @Produces("application/json")
    List<MedicalCase> myCases(@PathParam String username);   

    @POST
    @Path("/")
    @Produces("application/json")
    public MedicalCase createCase(MedicalCase medicalCase);

    
    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public MedicalCase updateCase(@PathParam Integer id,MedicalCase medicalCase);

}