package org.budgetbay;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.rest.service.impl.UserApiImpl;

@Slf4j
@Path("/v1/budgetBay/")
@RequiredArgsConstructor
public class BudgetBayController {

    @Inject
    private UserApiImpl userApi;

    @GET
    @Path("/test")
    public Response printConfig() {

        userApi.profile();
        return Response.ok("Config printed in logs").build();
    }
}
