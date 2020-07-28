package io.aloxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import org.hibernate.reactive.mutiny.Mutiny.Session;
import org.jboss.resteasy.annotations.cache.NoCache;

import io.smallrye.mutiny.Uni;

@Path("/")
@NoCache
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    Uni<Session> session;

    @GET
    @Path("/response")
    public Uni<Response> response() {
        return session.map(s -> Response.status(200).build());
    }

    @GET
    @Path("/response-status")
    public Uni<Response.StatusType> responseStatus() {
        return session.map(s -> Response.status(200).build().getStatusInfo());
    }

}