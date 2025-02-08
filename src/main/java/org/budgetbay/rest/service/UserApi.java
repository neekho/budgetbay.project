package org.budgetbay.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "user-ms")
@Path("/v1/users")
public interface UserApi {

    @GET
    @Path("/profile/{id}")
    UserProfileResponse requestUserProfile(String id);

}
