package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import test.configurationproperties.TestProperties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith({ SpringExtension.class })
@EnableConfigurationProperties(value = TestProperties.class)
//@TestPropertySource("classpath:yaml.yml")
@ContextConfiguration(initializers = TestApplicationContextInitializer.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class PropertiesTest {

    @Autowired
    private TestProperties testProperties;

    @Test
    void test() {
        assertThat(testProperties.getValue()).isEqualTo("foo");
    }

}