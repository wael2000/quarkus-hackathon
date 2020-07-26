package org.acme.composite.service;


import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


import org.acme.composite.model.CaseRequest;
//import org.acme.composite.model.CaseTask;

@Path("/requests")
@RegisterRestClient
public interface ProcessService {
    
    @POST
    @Path("/")
    @Produces("application/json")
    public CaseRequest startProcess(CaseRequest request);

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public CaseRequest getProcess(@PathParam String id);

    @GET
    @Path("/{id}/tasks")
    @Produces("application/json")
    public Map<String,String> getTasks(@PathParam String id);


}