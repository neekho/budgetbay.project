package org.budgetbay.rest.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.configuration.properties.UserConfigProperties;
import org.budgetbay.rest.dto.user.UserProfileRequest;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.budgetbay.rest.service.UserApi;
import org.budgetbay.service.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Slf4j
@ApplicationScoped
public class UserApiImpl implements UserApi {

    @Inject
    @RestClient
    UserService userService;

    @Override
    public UserProfileResponse profile() {
        log.info("[/profile] getting user profile");

        String userId = "1";

        UserProfileResponse response = userService.getUserProfile(userId);
        log.info("User profile retrieved: {}", response);

        return response;


    }
}
