package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.eclipse.microprofile.jwt.JsonWebToken;
import io.quarkus.oidc.IdToken;

@Path("/")
public class PageResource {
    @Inject
    Template index; 
    @Inject
    Template nearby; 
    @Inject
    Template newcase; 

    @Inject
    Template cases; 
    
    @Inject
    @IdToken
    JsonWebToken idToken;

    @ConfigProperty(name = "composite.url")
    String compositeURL;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/home")
    public TemplateInstance home() {
        return  index.data("composite",compositeURL).data("username", idToken.getName());
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/nearby")
    public TemplateInstance nearby() {
        return  nearby.data("composite",compositeURL).data("username", idToken.getName());
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/case")
    public TemplateInstance newcase() {
        return  newcase.data("composite",compositeURL)
                       .data("username", idToken.getName());
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/cases")
    public TemplateInstance cases() {
        return  cases.data("composite",compositeURL)
                       .data("username", idToken.getName());
    }
}