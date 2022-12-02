package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class EnvironmentPostProcessor implements org.springframework.boot.env.EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
    
    private final String ymlFile = "yaml.yml";
    private final String loadName = "custom-resource";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        Resource path = new ClassPathResource(ymlFile);
        PropertySource<?> propertySource = loadYaml(path);
        environment.getPropertySources().addLast(propertySource);
        //System.err.println(propertySource.getProperty("riot.security.oauth2.discovery-url"));
        System.err.println(environment.getProperty("riot.security.oauth2.discovery-url"));
    }

    private PropertySource<?> loadYaml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            return this.loader.load(loadName, path).get(0);
        }
        catch (IOException ex) {
            throw new IllegalStateException("Failed to load yaml configuration from " + path, ex);
        }
    }
}
