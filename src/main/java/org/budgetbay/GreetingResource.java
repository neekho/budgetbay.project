package org.budgetbay;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.configuration.properties.UserConfigProperties;
import org.budgetbay.rest.service.impl.UserApiImpl;

@Slf4j
@Path("/hello")
public class GreetingResource {

    @Inject
    UserConfigProperties userConfigProperties;

    @Inject
    UserApiImpl userApi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/config/print")
    public Response printConfig() {
        log.info("User Base Path: {}", userConfigProperties.getBasePath());
        log.info("Profile Endpoint: {}", userConfigProperties.getProfile());
        userApi.profile();
        return Response.ok("Config printed in logs").build();
    }
}
