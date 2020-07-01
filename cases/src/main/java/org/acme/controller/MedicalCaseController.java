package org.acme.controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import org.acme.model.MedicalCase;
import org.acme.services.MedicalCaseService;

@Path("/cases")
public class MedicalCaseController {
    @Inject
    MedicalCaseService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase[] cases() {
        return service.getAll();
    }

    @GET
    @Path("/physician/{physician}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase[] physicianCases(@PathParam String physician) {
        return service.getPhysicianCases(physician);
    }

    @GET
    @Path("/my/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase[] myCases(@PathParam String username) {
        return service.myCases(username);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase getCase(@PathParam Integer id) {
        return service.getMedicalCase(id);
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase createCase(MedicalCase medicalCase) {
        return service.createMedicalCase(medicalCase);
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase createCase(@PathParam Integer id,MedicalCase medicalCase) {
        return service.updateMedicalCase(id, medicalCase);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalCase deleteGift(@PathParam Integer id) {
        return service.deleteMedicalCase(id);
    }
}