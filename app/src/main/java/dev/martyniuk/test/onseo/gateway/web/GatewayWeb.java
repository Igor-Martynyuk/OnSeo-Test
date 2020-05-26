package dev.martyniuk.test.onseo.gateway.web;

public interface GatewayWeb {
    void update(
            Runnable onSuccess,
            Runnable onError
    );
}
