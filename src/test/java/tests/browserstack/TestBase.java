package tests.browserstack;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DeviceHost;
import drivers.BrowserstackDriver;
import drivers.EmulationDriver;
import drivers.RealDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static config.ConfigReader.deviceHost;

public class TestBase {

    @BeforeAll
    static void beforeAllSetUp() {
        Configuration.browser = getDriverClassName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        Configuration.savePageSource = deviceHost == DeviceHost.BROWSERSTACK;
    }

    @BeforeEach
    void beforeEachSetUp() {
        if (deviceHost == DeviceHost.BROWSERSTACK) {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }

        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();

        if (deviceHost == DeviceHost.BROWSERSTACK) {
            Attach.pageSource();
        }

        closeWebDriver();

        if (deviceHost == DeviceHost.BROWSERSTACK) {
            Attach.addVideo(sessionId);
        }
    }

    private static String getDriverClassName() {
        return switch (deviceHost) {
            case BROWSERSTACK -> BrowserstackDriver.class.getName();
            case EMULATION -> EmulationDriver.class.getName();
            case REAL -> RealDriver.class.getName();
        };
    }
}