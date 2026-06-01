package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/real.properties"
})
public interface RealConfig extends Config {

    @Key("url")
    URL getUrl();

    @Key("platformName")
    String getPlatformName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("udid")
    String getUdid();

    @Key("automationName")
    String getAutomationName();

    @Key("app")
    String getApp();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}