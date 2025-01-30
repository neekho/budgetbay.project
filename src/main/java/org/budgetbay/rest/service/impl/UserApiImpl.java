package org.budgetbay.rest.service.impl;

import jakarta.inject.Inject;
import org.budgetbay.configuration.properties.UserConfigProperties;
import org.budgetbay.rest.dto.user.UserResponse;
import org.budgetbay.rest.service.UserApi;

public class UserApiImpl implements UserApi {

    @Inject
    private UserConfigProperties userConfigProperties;

    @Override
    public UserResponse profile() {
        return null;
    }
}
