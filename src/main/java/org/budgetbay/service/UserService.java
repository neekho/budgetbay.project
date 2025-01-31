package org.budgetbay.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081") // Base URL specified here
public interface UserService {

    @GET
    @Path("v1/users/profile/{id}")
    UserProfileResponse getUserProfile(@PathParam("id") String id);

}
