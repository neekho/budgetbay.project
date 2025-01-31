package org.budgetbay.rest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {

    private int id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
