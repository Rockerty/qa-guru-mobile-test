package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static config.ConfigReader.emulationConfig;

public class EmulationDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(emulationConfig.getPlatformName());
        options.setPlatformVersion(emulationConfig.getPlatformVersion());
        options.setDeviceName(emulationConfig.getDeviceName());
        options.setAutomationName(emulationConfig.getAutomationName());

        options.setApp(getAppPath());
        options.setAppPackage(emulationConfig.getAppPackage());
        options.setAppActivity(emulationConfig.getAppActivity());

        return new AndroidDriver(emulationConfig.getUrl(), options);
    }

    private String getAppPath() {
        String app = emulationConfig.getApp();

        if (app.startsWith("http://") || app.startsWith("https://"))
            return app;

        return new File(app).getAbsolutePath();
    }
}