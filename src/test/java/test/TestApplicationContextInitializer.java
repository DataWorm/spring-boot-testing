package test;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class TestApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        var postProcessor = new EnvironmentPostProcessor();
        postProcessor.postProcessEnvironment(applicationContext.getEnvironment(), null);
    }
}
