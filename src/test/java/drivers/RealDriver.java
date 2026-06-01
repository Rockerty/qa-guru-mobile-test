package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static config.ConfigReader.realConfig;

public class RealDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(realConfig.getPlatformName());
        options.setPlatformVersion(realConfig.getPlatformVersion());
        options.setDeviceName(realConfig.getDeviceName());
        options.setUdid(realConfig.getUdid());
        options.setAutomationName(realConfig.getAutomationName());

        options.setApp(getAppPath());
        options.setAppPackage(realConfig.getAppPackage());
        options.setAppActivity(realConfig.getAppActivity());

        return new AndroidDriver(realConfig.getUrl(), options);
    }

    private String getAppPath() {
        String app = realConfig.getApp();

        if (app.startsWith("http://") || app.startsWith("https://"))
            return app;

        return new File(app).getAbsolutePath();
    }
}