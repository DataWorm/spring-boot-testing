package test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfiguration
public class TestConfig {

    @Bean
    OpenIdConnectDiscovery openIdConnectDiscoveryMock() {
        var oidcConfigMock = mock(OpenIdConfig.class);
        var openIdConnectDiscoveryMock = mock(OpenIdConnectDiscovery.class);
        when(openIdConnectDiscoveryMock.getRemoteOpenIdConnectConfig()).thenReturn(Mono.just(oidcConfigMock));
        return openIdConnectDiscoveryMock;
    }

}
