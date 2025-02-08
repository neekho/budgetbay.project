package org.budgetbay;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.budgetbay.repository.CategoryRepository;
import org.budgetbay.service.UserService;

@Path("/v1/budgetBay/")
@RequiredArgsConstructor
public class BudgetBayController {

    @Inject
    private UserService userService;

    @Inject
    CategoryRepository categoryRepository;

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@PathParam("id") String id) {
        categoryRepository.listAll();
        return Response.ok(userService.requestUserProfile(id)).build();
    }
}
