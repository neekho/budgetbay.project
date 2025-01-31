package org.budgetbay.rest.dto.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public final class UserProfileRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7951743237024969991L;

    private String id;

}
