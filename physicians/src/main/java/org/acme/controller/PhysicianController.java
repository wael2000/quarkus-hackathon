package org.acme.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import jdk.nashorn.internal.objects.annotations.Getter;

import org.acme.model.Physician;
import org.acme.model.Speciality;

@Path("/physician")
@Consumes("application/json")
@Produces("application/json")
public class PhysicianController {
    @GET
    public List<Physician> list() {
        return Physician.listAll();
    }

    @GET
    @Path("/{id}")
    public Physician get(@PathParam("id") String id) {
        return Physician.findById(new ObjectId(id));
    }

    @POST
    public Physician create(Physician physician) {
        physician.persist();
        return physician;
        //return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Physician physician) {
        physician.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Physician physician = Physician.findById(new ObjectId(id));
        physician.delete();
    }

    @GET
    @Path("/search/{name}")
    public Physician search(@PathParam("name") String name) {
        return Physician.findByName(name);
    }

    @POST
    @Path("/nearBy/{distance}")
    public List<Physician> nearBy(@PathParam("distance") Double distance,Map params) {
        return Physician.findNearBy(distance,params);
    }

    @GET
    @Path("/count")
    public Long count() {
        return Physician.count();
    }

    @GET
    @Path("/speciality")
    public List<String> speciality(){
        return Speciality.speciality;
    }
}