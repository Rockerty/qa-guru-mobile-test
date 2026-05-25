package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}