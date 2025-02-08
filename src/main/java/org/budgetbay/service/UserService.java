package org.budgetbay.service;

import jakarta.ws.rs.PathParam;
import org.budgetbay.rest.dto.user.UserProfileResponse;

public interface UserService {

    UserProfileResponse requestUserProfile(@PathParam("id") String id);

}
