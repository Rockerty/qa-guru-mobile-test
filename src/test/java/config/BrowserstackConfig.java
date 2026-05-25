package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("url")
    URL getUrl();

    @Key("app")
    String getApp();
}