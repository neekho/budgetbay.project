package org.budgetbay.configuration.properties;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import lombok.Getter;

@Getter
public abstract class HttpApiConfigProperties {

    private final Client client;
    private final WebTarget baseTarget;
    private final String basePath;

    public HttpApiConfigProperties(String basePath) {
        this.client = ClientBuilder.newClient();
        this.basePath = basePath;
        this.baseTarget = client.target(basePath);
    }

    public WebTarget buildTarget(String path) {
        return baseTarget.path(path);
    }
}
