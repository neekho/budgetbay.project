package org.budgetbay.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.budgetbay.service.biz.UserService;

@Path("/v1/budgetBay")
public class BudgetBayController {

    @Inject
    private UserService userService;

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponse test(@PathParam("id") String id) {
        return userService.requestUserProfile(id);
    }

}
