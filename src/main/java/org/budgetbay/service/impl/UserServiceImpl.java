package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.budgetbay.rest.service.UserApi;
import org.budgetbay.service.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Inject
    @RestClient
    private UserApi userApi;

    @Override
    public UserProfileResponse requestUserProfile(String id) {
        log.info("calling us ms..");
        return userApi.requestUserProfile(id);

    }
}
