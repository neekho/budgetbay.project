package org.budgetbay;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.rest.service.UserApi;
import org.budgetbay.service.UserService;

@Path("/v1/budgetBay/")
@RequiredArgsConstructor
public class BudgetBayController {

    @Inject
    private UserService userService;

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response printConfig(@PathParam("id") String id) {

        return Response.ok(userService.requestUserProfile(id)).build();
    }
}
