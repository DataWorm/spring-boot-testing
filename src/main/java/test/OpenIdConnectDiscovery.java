package test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Establishes a GET connection to a OpenId-Connect discovery endpoint
 */
@Component
@RequiredArgsConstructor
public class OpenIdConnectDiscovery {

    private final WebClient.Builder oidcDiscoveryClientBuilder;

    public Mono<OpenIdConfig> getRemoteOpenIdConnectConfig() {
        return oidcDiscoveryClientBuilder.build().get().retrieve().bodyToMono(OpenIdConfig.class);
    }
}
