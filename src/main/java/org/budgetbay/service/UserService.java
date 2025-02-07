package org.budgetbay.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey ="user-ms")
@Path("/v1/users")
public interface UserService {

    @GET
    @Path("/profile/{id}")
    UserProfileResponse getUserProfile(@PathParam("id") String id);

}
