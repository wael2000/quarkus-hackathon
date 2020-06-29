package org.acme.composite.resources;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;
import org.acme.composite.service.PhysicianService;
import org.acme.composite.service.MedicalCaseService;
import org.acme.composite.model.PhysicianProfile;
//import org.acme.composite.model.MedicalCase;
import org.acme.model.MedicalCase;

@Path("/profile")
public class ProfileResource {
    
    @Inject
    @RestClient
    PhysicianService physicianService;

    @Inject
    @RestClient
    MedicalCaseService medicalCaseService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PhysicianProfile getPhysician(@PathParam String id){
        PhysicianProfile physicianProfile = physicianService.getPhysician(id);
        physicianProfile.cases =  medicalCaseService.getCases(physicianProfile.id);
        return physicianProfile;
    }
   
}