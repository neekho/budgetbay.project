package org.budgetbay.rest.dto.user;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {

    private int id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
