package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final DeviceHost deviceHost =
            DeviceHost.fromString(System.getProperty("deviceHost", "browserstack"));

    public static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static final EmulationConfig emulationConfig =
            ConfigFactory.create(EmulationConfig.class, System.getProperties());

    public static final RealConfig realConfig =
            ConfigFactory.create(RealConfig.class, System.getProperties());
}