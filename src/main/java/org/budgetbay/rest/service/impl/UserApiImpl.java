package org.budgetbay.rest.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.configuration.properties.UserConfigProperties;
import org.budgetbay.rest.dto.user.UserProfileResponse;
import org.budgetbay.rest.service.UserApi;

@Slf4j
@ApplicationScoped
public class UserApiImpl implements UserApi {

    @Inject
    UserConfigProperties userConfigProperties;

    @Override
    public UserProfileResponse profile() {
        //make POST request to USER microservice, to the profile/{id} resource
        log.info("[/profile] getting user profile");
        return null;
    }
}
