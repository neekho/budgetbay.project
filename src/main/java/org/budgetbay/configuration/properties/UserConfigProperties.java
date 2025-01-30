package org.budgetbay.configuration.properties;

import io.smallrye.config.ConfigMapping;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ConfigMapping(prefix = "budgetbay.microservice.user")
public class UserConfigProperties extends HttpApiConfigProperties {

    public UserConfigProperties(String basePath) {
        super(basePath);
    }

    @NotNull
    private String profile;

}
