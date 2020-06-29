package org.acme.composite.service;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

import org.acme.composite.model.PhysicianProfile;

@Path("/physician")
@RegisterRestClient
public interface PhysicianService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    PhysicianProfile getPhysician(@PathParam String id);
    
    /**
    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    List<PhysicianProfile> getByName(@PathParam String name);
    */
    
}
