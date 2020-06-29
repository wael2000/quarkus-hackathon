package org.acme.composite.service;

import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

import org.acme.composite.model.CaseRequest;

@Path("/requests")
@RegisterRestClient
public interface ProcessService {
    
    @POST
    @Path("/")
    @Produces("application/json")
    public CaseRequest startProcess(CaseRequest request);

}