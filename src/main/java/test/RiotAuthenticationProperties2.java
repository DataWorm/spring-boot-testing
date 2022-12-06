package test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "riot.security")
@Data
public class RiotAuthenticationProperties2 {

    private int repeatingIntervalMin;



}
