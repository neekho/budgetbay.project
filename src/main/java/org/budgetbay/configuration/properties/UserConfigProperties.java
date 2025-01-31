package org.budgetbay.configuration.properties;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ConfigMapping(prefix = "budgetbay.microservice.user")
public class UserConfigProperties extends HttpApiConfigProperties{

    @NotNull
    private String profile;

    @NotNull
    private String basePath;

    public UserConfigProperties(String basePath, String profile) {
        super(basePath);
        this.profile = profile;
    }
}

