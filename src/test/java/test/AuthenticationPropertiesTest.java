package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith({ SpringExtension.class })
@EnableConfigurationProperties(value = {RiotAuthenticationProperties.class, RiotAuthenticationProperties2.class})
@ContextConfiguration(classes = {
        TestConfig.class
})
@PropertySource("test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class AuthenticationPropertiesTest {

    private static final Integer REFRESH_INTERVAL = 1;

    @Autowired
    private RiotAuthenticationProperties authenticationProperties;

    @Autowired
    private RiotAuthenticationProperties2 authenticationProperties2;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("REFRESH_INTERVAL", REFRESH_INTERVAL.toString());
    }

    @Test
    void update_OAuth2_Properties() {
        assertThat(authenticationProperties.getRepeatingIntervalMin()).isEqualTo(REFRESH_INTERVAL);
    }

    @Test
    void update_OAuth2_Properties2() {
        assertThat(authenticationProperties2.getRepeatingIntervalMin()).isEqualTo(REFRESH_INTERVAL);
    }

    @AfterAll
    static void afterAll() {
        System.clearProperty("REFRESH_INTERVAL");
    }

}