package org.budgetbay;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.budgetbay.service.ProductService;
import org.budgetbay.service.biz.UserService;

@Path("/v1/budgetBay/")
@RequiredArgsConstructor
public class BudgetBayController {

    @Inject
    private UserService userService;

    @Inject
    private ProductService productService;

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponse test(@PathParam("id") String id) {
        return userService.requestUserProfile(id);
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductsResponse testProducts() {
        return productService.productsResponse(new ProductsRequest("laptops"));
    }

}
